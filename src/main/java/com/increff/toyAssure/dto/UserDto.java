package com.increff.toyAssure.dto;

import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.UserData;
import com.increff.toyAssure.model.form.UserForm;
import com.increff.toyAssure.pojo.UserPojo;
import com.increff.toyAssure.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.increff.toyAssure.dto.dtoHelper.UserDtoHelper.*;

@Service
public class UserDto
{

    @Autowired
    private UserApi userService;

    public List<UserData> getAll()
    {
        return convertUserPojoListtoUserDataList(userService.selectAll());
    }

    public UserData get(Long id)throws ApiException
    {
        UserPojo userPojo = userService.selectByUserId(id);
        return convertUserPojotoUserData(userPojo);
    }

    public void add(UserForm userForm)throws ApiException
    {

        validate(userForm);
        userForm=normalize(userForm);
        userService.add(convertUserFormtoUserPojo(userForm));
    }

}
