package com.increff.toyAssure.dto.dtoHelper;

import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.ChannelData;
import com.increff.toyAssure.model.dataForUI.ChannelDataUI;
import com.increff.toyAssure.model.form.ChannelForm;
import com.increff.toyAssure.pojo.ChannelPojo;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class channelDtoHelper
{
    public static ChannelDataUI convertChannelFormtoChannelDataUI(ChannelForm channelForm)
    {
        ChannelDataUI channelDataUI = new ChannelDataUI();
        channelDataUI.setName(channelForm.getName());
        channelDataUI.setInvoiceType(channelForm.getInvoiceType());
        return channelDataUI;
    }

    public static ChannelData convertChannelPojotoChanneData(ChannelPojo channelPojo)
    {
        ChannelData channelData = new ChannelData();
        channelData.setName(channelPojo.getName());
        channelData.setInvoiceType(channelPojo.getInvoiceType());
        return channelData;
    }

    public static List<ChannelData> convertChannelPojoListtoChannelDataList(List<ChannelPojo> channelPojoList)
    {
        List<ChannelData> channelDataList= new ArrayList<>();
        for(ChannelPojo channelPojo : channelPojoList)
        {
            channelDataList.add(convertChannelPojotoChanneData(channelPojo));
        }
        return channelDataList;
    }

    public static ChannelPojo convertChannelFormtoChannelPojo(ChannelForm channelForm)
    {
        ChannelPojo channelPojo = new ChannelPojo();
        channelPojo.setName(channelForm.getName());
        channelPojo.setInvoiceType(channelForm.getInvoiceType());
        return channelPojo;
    }

    public static void validate(ChannelForm channelForm)throws ApiException
    {
        if(isNull(channelForm.getName()) || channelForm.getName().isEmpty())
        {
            throw new ApiException("Channel Name cannot be Empty or Null");
        }
        if(isNull(channelForm.getInvoiceType()))
        {
            throw new ApiException("Channel Invoice Type Cannot be Empty or Null");
        }
    }

    public static ChannelForm normalize(ChannelForm channelForm)
    {
        channelForm.setName(channelForm.getName().trim().toLowerCase());
        channelForm.setInvoiceType(channelForm.getInvoiceType());
        return channelForm;

    }
}
