package com.increff.toyAssure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.increff.toyAssure.dao.ChannelDao;
import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.pojo.ChannelPojo;

import java.util.List;

@Service
@Transactional(rollbackFor = ApiException.class)
public class ChannelService
{

    @Autowired
    private ChannelDao channelDao;

    public List<ChannelPojo> selectAll()
    {
        return channelDao.selectAll();
    }

    public ChannelPojo selectByChannel(String name)
    {
        return channelDao.selectByChannel(name);

    }

    public void add(ChannelPojo channelPojo)
    {
        channelDao.add(channelPojo);
    }

}
