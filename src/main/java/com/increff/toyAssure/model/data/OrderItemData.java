package com.increff.toyAssure.model.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemData
{
    private Long orderId;
    private String clientSkuId;
    private Long orderedId;
    private Double sellingPricePerUnit;
}
