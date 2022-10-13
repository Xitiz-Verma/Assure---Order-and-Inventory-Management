package com.increff.toyAssure.dto.dtoHelper;

import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.UserData;
import com.increff.toyAssure.model.dataForUI.UserDataUI;
import com.increff.toyAssure.model.form.UserForm;
import com.increff.toyAssure.pojo.UserPojo;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class UserDtoHelper
{
    public static UserData convertUserPojotoUserData(UserPojo userPojo)
    {
        UserData userData = new UserData();
        userData.setName(userPojo.getName());
        userData.setUserType(userPojo.getUserType());
        userData.setId(userPojo.getId());
        return userData;
    }

    public static List<UserData> convertUserPojoListtoUserDataList(List<UserPojo> userPojoList)
    {
        List<UserData> userDataList = new ArrayList<>();
        for(UserPojo userPojo : userPojoList)
        {
            userDataList.add(convertUserPojotoUserData(userPojo));
        }
        return userDataList;
    }

    public static UserDataUI convertUserFormtoUserDataUI(UserForm userForm)
    {
        UserDataUI userDataUI = new UserDataUI();
        userDataUI.setName(userForm.getName());
        userDataUI.setUserType(userForm.getUserType());
        return userDataUI;
    }

    public static UserPojo convertUserFormtoUserPojo(UserForm userForm)
    {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(userForm.getName());
        userPojo.setUserType(userForm.getUserType());
        return userPojo;
    }

    public static void validate(UserForm userForm)throws ApiException
    {
        if(isNull(userForm.getName()) || userForm.getName().isEmpty())
        {
            throw new ApiException("Username cannot be null or empty");
        }
        if(isNull(userForm.getUserType()))
        {
            throw new ApiException("UserType cannot be null");
        }
    }

    public static UserForm normalize(UserForm userForm)
    {
        userForm.setName(userForm.getName().trim().toLowerCase());
        userForm.setUserType(userForm.getUserType());
        return userForm;
    }
}
