package com.increff.toyAssure.model.form;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class BinSkuForm
{
    @NotNull
    private Long clientId;
    @NotEmpty
    private List<BinSkuItemForm> binSkuItemFormList;
}
