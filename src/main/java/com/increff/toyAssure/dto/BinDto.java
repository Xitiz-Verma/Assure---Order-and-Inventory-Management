package com.increff.toyAssure.dto;

import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.BinData;
import com.increff.toyAssure.api.BinApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.increff.toyAssure.dto.dtoHelper.BinDtoHelper.convertBinPojoListtoBinDataList;

@Service
public class BinDto
{
    private static final Long MAX_BIN_SIZE = 100L;

    @Autowired
    private BinApi binService;

    public List<BinData> add(Long numberOfBins)throws ApiException
    {
        if(numberOfBins > MAX_BIN_SIZE)
        {
            throw new ApiException("Number of Bins is greater than Max Limit, limit : " + MAX_BIN_SIZE);
        }
        return convertBinPojoListtoBinDataList(binService.add(numberOfBins));
    }

    public List<BinData> getAll()
    {
        return convertBinPojoListtoBinDataList(binService.selectAll());
    }
}
