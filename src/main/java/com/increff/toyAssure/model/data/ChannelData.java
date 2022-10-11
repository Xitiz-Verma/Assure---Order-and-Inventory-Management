package com.increff.toyAssure.model.data;

import lombok.Getter;
import lombok.Setter;
import com.increff.toyAssure.util.InvoiceType;

@Getter
@Setter
public class ChannelData
{
    private String name;
    private InvoiceType invoiceType;

}
