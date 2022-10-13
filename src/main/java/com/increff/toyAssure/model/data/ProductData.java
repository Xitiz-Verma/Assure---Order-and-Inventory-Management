package com.increff.toyAssure.model.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductData
{
    private Long globalSkuId;
    private String clientSkuId;
    private Long clientId;
    private String name;
    private String brandId;
    private Double mrp;
    private String description;
}
