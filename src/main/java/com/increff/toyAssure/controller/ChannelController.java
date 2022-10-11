package com.increff.toyAssure.controller;

import com.increff.toyAssure.model.dataForUI.ChannelDataUI;
import com.increff.toyAssure.model.form.ChannelForm;
import com.increff.toyAssure.dto.ChannelDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.ChannelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/api/")
public class ChannelController
{
    @Autowired
    private ChannelDto channelDto;

    @ApiOperation(value = "Get Channels")
    @RequestMapping(path = "/channels",method = RequestMethod.GET)
    public List<ChannelData> getChannels()
    {
        return channelDto.getAll();
    }

    @ApiOperation(value="Add Channel")
    @RequestMapping(path="/channels", method = RequestMethod.POST)
    public ChannelDataUI addChannel(@RequestBody ChannelForm channelForm)throws ApiException
    {
        return channelDto.add(channelForm);
    }
}
