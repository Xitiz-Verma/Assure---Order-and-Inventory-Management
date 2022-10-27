package com.increff.toyAssure.dto.dtoHelper;

import com.increff.toyAssure.model.data.BinData;
import com.increff.toyAssure.pojo.BinPojo;

import java.util.ArrayList;
import java.util.List;

public class BinDtoHelper
{
    public static List<BinData> convertBinPojoListtoBinDataList(List<BinPojo> binPojoList)
    {
        List<BinData> binDataList = new ArrayList<>();
        for(BinPojo binPojo : binPojoList)
        {
            binDataList.add(convertBinPojotoBinData(binPojo));
        }
        return binDataList;
    }

    public static BinData convertBinPojotoBinData(BinPojo binPojo)
    {
        BinData binData = new BinData();
        binData.setBinId(binPojo.getBinId());
        return binData;
    }
}
