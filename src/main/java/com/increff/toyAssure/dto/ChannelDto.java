package com.increff.toyAssure.dto;

import com.increff.toyAssure.model.dataForUI.ChannelDataUI;
import com.increff.toyAssure.model.form.ChannelForm;
import com.increff.toyAssure.pojo.ChannelPojo;
import com.increff.toyAssure.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.ChannelData;

import java.util.List;

import static java.util.Objects.isNull;
import static com.increff.toyAssure.dto.dtoHelper.channelDtoHelper.*;
@Service
public class ChannelDto
{

    @Autowired
    private ChannelService channelService;

    public List<ChannelData> getAll()
    {
        return convertChannelPojoListtoChannelDataList(channelService.selectAll());
    }

    public ChannelDataUI add(ChannelForm channelForm)throws ApiException
    {
        channelForm = normalize(channelForm);
        validate(channelForm);
        ChannelPojo channelPojo = convertChannelFormtoChannelPojo(channelForm);
        getCheckChannelExists(channelPojo);

        channelService.add(channelPojo);
        return convertChannelFormtoChannelDataUI(channelForm);
    }

    public void getCheckChannelExists(ChannelPojo channelPojo)throws ApiException
    {
        if(isNull(channelService.selectByChannel(channelPojo.getName()))==false)
        {
            throw new ApiException("Channel Already exists, channel = " + channelPojo.getName());
        }
    }





}
