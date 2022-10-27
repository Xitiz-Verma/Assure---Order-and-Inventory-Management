package com.increff.toyAssure.dto;

import com.google.common.collect.ImmutableMap;
import com.increff.toyAssure.api.*;
import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.form.OrderForm;
import com.increff.toyAssure.model.form.OrderItemForm;
import com.increff.toyAssure.model.form.OrderStatusUpdateForm;
import com.increff.toyAssure.pojo.ChannelPojo;
import com.increff.toyAssure.pojo.OrderItemPojo;
import com.increff.toyAssure.pojo.OrderPojo;
import com.increff.toyAssure.util.OrderStatus;
import com.increff.toyAssure.util.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.increff.toyAssure.util.OrderStatus.ALLOCATED;
import static com.increff.toyAssure.util.OrderStatus.FULFILLED;
import static com.increff.toyAssure.util.ValidationUtil.validateList;
import static java.util.Objects.isNull;

@Service
@Transactional(rollbackFor = ApiException.class)
public class OrderDto
{

    private final static Long MAX_LIST_SIZE = 1000L;

    private final static String INTERNAL_CHANNEL = "INTERNAL";

    private final static Map<OrderStatus, OrderStatus> validStatusUpdateMap =
            ImmutableMap.<OrderStatus, OrderStatus>builder()
            .put(OrderStatus.CREATED,ALLOCATED).put(ALLOCATED,FULFILLED).build();

    @Autowired
    private OrderApi orderApi;

    @Autowired
    private UserApi userApi;

    @Autowired
    private ChannelApi channelApi;

    @Autowired
    private ProductApi productApi;

    @Autowired
    private InventoryApi inventoryApi;

    @Autowired
    private BinSkuApi binSkuApi;

    public Integer add(OrderForm orderForm)throws ApiException
    {
        List<OrderItemForm> orderItemFormList = orderForm.getOrderItemFormList();
        validateList("Order Item List",orderItemFormList,MAX_LIST_SIZE);
        checkDuplicateClientSkuIds(orderItemFormList);

        userApi.checkByIdAndType(orderForm.getClientId(), UserType.CLIENT);
        userApi.checkByIdAndType(orderForm.getCustomerId(), UserType.CUSTOMER);

        ChannelPojo channelPojo = channelApi.selectByChannelName(INTERNAL_CHANNEL);
        if(isNull(channelPojo))
        {
            throw new ApiException(INTERNAL_CHANNEL+ " channel does not exist");
        }

        Long channelId = channelPojo.getId();
        String channelOrderId = orderForm.getChannelOrderId();
        checkChannelIdAndChannelPairNotExist(channelId,channelOrderId);

        Map<String,Long> clientSkuIdtoGlobalSkuIdMap = getCheckClientSkuId(orderItemFormList,orderForm.getClientId());
        OrderPojo orderPojo = convertOrderFormtoOrderPojo(orderForm);
        List<OrderItemPojo> orderItemPojoList = convertOrderItemFormListtoOrderItemPojoList(orderItemFormList,clientSkuIdtoGlobalSkuIdMap);
        orderApi.add(orderPojo,orderItemPojoList);
        return orderItemFormList.size();
    }

    public void updateStatus(OrderStatusUpdateForm orderStatusUpdateForm)throws ApiException
    {
        validateForm(orderStatusUpdateForm);
        OrderPojo orderPojo = orderApi.getCheck(orderStatusUpdateForm.getOrderId());

        if(validStatusUpdateMap.get(orderPojo.getStatus())!=orderStatusUpdateForm.getUpdateStatusTo())
        {
            throw new ApiException("Invalid Order Update Status");
        }
        OrderStatus orderStatus = validStatusUpdateMap.get(OrderPojo.getStatus);
        switch(orderStatus)
        {
            case ALLOCATED: allocateOrder(orderStatusUpdateForm.getOrderId());break;
            case FULFILLED: fulfillOrder(orderStatusUpdateForm.getOrderId());break;
        }
    }

    private void checkChannelIdAndChannelPairNotExist(Long channelId, String channelOrderId)throws ApiException
    {
        if(!isNull(orderApi.selectByChannelIdAndChannelOrderId(channelId,channelOrderId)))
        {
            throw new ApiException("Channel Order Id already exists for this Channel");
        }
    }
}
