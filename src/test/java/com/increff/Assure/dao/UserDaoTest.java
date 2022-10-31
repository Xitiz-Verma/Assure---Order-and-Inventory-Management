package com.increff.Assure.dao;

import com.increff.Assure.dto.QAConfig;
import com.increff.Assure.pojo.UserPojo;
import com.increff.Assure.util.UserType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.increff.Assure.util.RandomUtil.getRandomString;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = QAConfig.class,loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration("src/test/webapp")
@Transactional
public class UserDaoTest
{

    @Autowired
    private UserDao userDao;

    @Test
    public void add()
    {
        UserPojo userPojo = new UserPojo();
        String name = getRandomString();
        userPojo.setName(name);
        userPojo.setUserType(UserType.CLIENT);
        userDao.add(userPojo);
    }



}
