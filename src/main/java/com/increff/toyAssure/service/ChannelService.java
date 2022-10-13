package com.increff.toyAssure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.increff.toyAssure.dao.ChannelDao;
import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.pojo.ChannelPojo;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@Transactional(rollbackFor = ApiException.class)
public class ChannelService
{

    @Autowired
    private ChannelDao channelDao;

    @Transactional(readOnly = true)
    public List<ChannelPojo> selectAll()
    {
        return channelDao.selectAll();
    }

    public void add(ChannelPojo channelPojo)throws ApiException
    {
        getCheckChannelExists(channelPojo);
        channelDao.add(channelPojo);
    }
    public void getCheckChannelExists(ChannelPojo channelPojo)throws ApiException
    {
        if(isNull(channelDao.selectByChannel(channelPojo.getName()))==false)
        {
            throw new ApiException("Channel Already exists, channel = " + channelPojo.getName());
        }
    }

}
