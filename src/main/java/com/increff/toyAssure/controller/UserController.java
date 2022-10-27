package com.increff.toyAssure.controller;

import com.increff.toyAssure.dto.UserDto;
import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.UserData;
import com.increff.toyAssure.model.form.UserForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class UserController
{

    @Autowired
    private UserDto userDto;

    @ApiOperation(value = "Get All Users")
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<UserData> getUsers()
    {
        return userDto.getAll();
    }

    @ApiOperation(value = "Get User By Id")
    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public UserData getUserById(@PathVariable Long id)throws ApiException
    {
        return userDto.get(id);
    }

    @ApiOperation(value = "Add an User(Client/Customer)")
    @RequestMapping(path = "/users", method =RequestMethod.POST)
    public void add(@RequestBody UserForm userForm)throws ApiException
    {
        //TODO:add controller level checking check enum annotations
        userDto.add(userForm);
    }
}
