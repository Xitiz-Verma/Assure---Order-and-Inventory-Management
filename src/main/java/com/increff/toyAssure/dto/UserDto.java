package com.increff.toyAssure.dto;

import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.UserData;
import com.increff.toyAssure.model.dataForUI.UserDataUI;
import com.increff.toyAssure.model.form.UserForm;
import com.increff.toyAssure.pojo.UserPojo;
import com.increff.toyAssure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.increff.toyAssure.dto.dtoHelper.UserDtoHelper.*;

@Service
public class UserDto
{

    @Autowired
    private UserService userService;

    public List<UserData> getAll()
    {
        return convertUserPojoListtoUserDataList(userService.selectAll());
    }

    public UserData get(Long id)throws ApiException
    {
        UserPojo userPojo = userService.selectByUserId(id);
        if(Objects.isNull(userPojo))
        {
            throw new ApiException("Given User with id does not exist = " + id);
        }
        return convertUserPojotoUserData(userPojo);
    }

    public UserDataUI add(UserForm userForm)throws ApiException
    {

        validate(userForm);
        userForm=normalize(userForm);
        userService.add(convertUserFormtoUserPojo(userForm));
        return convertUserFormtoUserDataUI(userForm);
    }

}
