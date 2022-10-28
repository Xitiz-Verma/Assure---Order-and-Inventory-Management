package com.increff.toyAssure.dto.dtoHelper;

import com.increff.toyAssure.model.data.OrderItemData;
import com.increff.toyAssure.model.form.OrderForm;
import com.increff.toyAssure.model.form.OrderItemForm;
import com.increff.toyAssure.pojo.OrderItemPojo;
import com.increff.toyAssure.pojo.OrderPojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class OrderDtoHelper
{
    public static OrderPojo convertOrderFormtoOrderPojo(OrderForm orderForm)
    {
        OrderPojo orderPojo = new OrderPojo();
        orderPojo.setChannelOrderId(orderForm.getChannelOrderId());
        orderPojo.setChannelId(orderForm.getChannelId());
        orderPojo.setClientId(orderForm.getClientId());
        orderPojo.setCustomerId(orderForm.getCustomerId());
        return orderPojo;
    }

    public static List<OrderItemPojo> convertOrderItemFormListtoOrderItemPojoList(List<OrderItemForm> orderItemFormList, Map<String,Long> clientSkuIdtoGlobalSkuIdMap)
    {
        List<OrderItemPojo> orderItemPojoList = new ArrayList<>();
        for(OrderItemForm orderItemForm : orderItemFormList)
        {
            OrderItemPojo orderItemPojo = new OrderItemPojo();
            orderItemPojo.setGlobalSkuId(clientSkuIdtoGlobalSkuIdMap.get(orderItemForm.getClientSkuId()));
            orderItemPojo.setOrderedQuantity(orderItemForm.getQuantity());
            orderItemPojo.setSellingPricePerUnit(orderItemForm.getSellingPricePerUnit());
            orderItemPojoList.add(orderItemPojo);
        }
        return orderItemPojoList;
    }

    public static OrderItemData convertOrderItemPojotoOrderItemData(OrderItemPojo orderItemPojo, String clientSkuId)
    {
        OrderItemData orderItemData = new OrderItemData();
        orderItemData.setOrderId(orderItemPojo.getOrderId());
        orderItemData.setOrderedQuantity(orderItemPojo.getOrderedQuantity());
        orderItemData.setClientSkuId(clientSkuId);
        orderItemData.setSellingPricePerUnit(orderItemPojo.getSellingPricePerUnit());
        return orderItemData;

    }
}
