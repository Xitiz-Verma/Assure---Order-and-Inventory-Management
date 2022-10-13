package com.increff.toyAssure.model.data;

import com.increff.toyAssure.util.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData
{
    private Long id;
    private String name;
    private UserType userType;

}
