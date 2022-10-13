package com.increff.toyAssure.service;

import com.increff.toyAssure.dao.UserDao;
import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.pojo.UserPojo;
import com.increff.toyAssure.util.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional(rollbackFor = ApiException.class)
public class UserService
{

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    public List<UserPojo> selectAll()
    {
        return userDao.selectAll();
    }

    public void add(UserPojo userPojo)throws ApiException
    {
        UserPojo userPojo2 = selectByNameandUserType(userPojo.getName(),userPojo.getUserType());
        if(Objects.isNull(userPojo2)==false)
        {
            throw new ApiException("User Name and User Type Combination already exists");
        }
        userDao.add(userPojo);
    }
    public UserPojo selectByUserId(Long id)
    {
        return userDao.selectByUserId(id);
    }

    public UserPojo selectByNameandUserType(String name, UserType userType)
    {
        return userDao.selectByNameandUserType(name,userType);
    }

}
