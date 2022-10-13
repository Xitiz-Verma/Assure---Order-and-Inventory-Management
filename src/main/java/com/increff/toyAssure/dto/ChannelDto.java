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
import static com.increff.toyAssure.dto.dtoHelper.ChannelDtoHelper.*;
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
        validate(channelForm);
        channelForm = normalize(channelForm);
        channelService.add(convertChannelFormtoChannelPojo(channelForm));
        return convertChannelFormtoChannelDataUI(channelForm);
    }







}
