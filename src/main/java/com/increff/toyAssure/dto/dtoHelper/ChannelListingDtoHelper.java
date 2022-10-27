package com.increff.toyAssure.dto.dtoHelper;

import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.ErrorData;
import com.increff.toyAssure.model.form.ChannelListingForm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.increff.toyAssure.util.ValidationUtil.throwErrorIfNotEmpty;

public class ChannelListingDtoHelper
{

    public static void checkDuplicateChannelListingFormList(List<ChannelListingForm> channelListingFormList)throws ApiException
    {
        HashSet<String> hashSetChannelSkuId = new HashSet<>();
        HashSet<String> hashSetClientSkuId = new HashSet<>();
        List<ErrorData> errorDataList = new ArrayList<>();

        Long row = 1L;
        for(ChannelListingForm channelListingForm : channelListingFormList)
        {
            if(hashSetChannelSkuId.contains(channelListingForm.getChannelSkuId()))
            {
                errorDataList.add(new ErrorData(row,"Duplicate Values of ChannelSkuId"));
            }
            if(hashSetClientSkuId.contains(channelListingForm.getClientSkuId()))
            {
                errorDataList.add(new ErrorData(row, "Duplicate Values of ClientSkuId"));
            }

            hashSetChannelSkuId.add(channelListingForm.getChannelSkuId());
            hashSetClientSkuId.add(channelListingForm.getClientSkuId());
            row++;
        }
        throwErrorIfNotEmpty(errorDataList);
    }
}
