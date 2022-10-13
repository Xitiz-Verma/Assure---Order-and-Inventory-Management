package com.increff.toyAssure.model.form;

import com.increff.toyAssure.util.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserForm
{
    @NotBlank
    private String name;
    @NotNull
    private UserType userType;
}
