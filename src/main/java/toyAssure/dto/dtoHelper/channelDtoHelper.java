package toyAssure.dto.dtoHelper;

import toyAssure.model.data.ChannelData;
import toyAssure.model.dataForUI.ChannelDataUI;
import toyAssure.model.form.ChannelForm;
import toyAssure.pojo.ChannelPojo;

import java.util.ArrayList;
import java.util.List;

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
}
