package toyAssure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyAssure.dao.ChannelDao;
import toyAssure.exception.ApiException;
import toyAssure.pojo.ChannelPojo;

import java.util.List;

@Service
@Transactional(rollbackFor = ApiException.class)
public class ChannelService
{

    @Autowired
    private ChannelDao channelDao;

    public List<ChannelPojo> getAll()
    {
        return channelDao.selectAll();
    }

}
