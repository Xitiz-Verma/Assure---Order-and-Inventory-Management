package toyAssure.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toyAssure.model.data.ChannelData;
import toyAssure.service.ChannelService;

import java.util.List;

import static toyAssure.dto.dtoHelper.channelDtoHelper.*;
@Service
public class ChannelDto
{

    @Autowired
    private ChannelService channelService;
    public List<ChannelData> getAll()
    {
        return convertChannelPojoListtoChannelDataList(channelService.getAll());
    }


}
