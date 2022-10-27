package com.increff.toyAssure.dto.dtoHelper;

import com.increff.toyAssure.model.data.BinSkuData;
import com.increff.toyAssure.model.form.BinSkuItemForm;
import com.increff.toyAssure.model.form.BinSkuUpdateForm;
import com.increff.toyAssure.pojo.BinSkuPojo;
import com.increff.toyAssure.pojo.InventoryPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;

public class BinSkuDtoHelper
{
    public static List<BinSkuPojo> convertBinSkuItemFormListToBinSkuItemPojo(List<BinSkuItemForm> binSkuItemFormList, HashMap<String,Long> clientToGlobalSku)
    {
        List<BinSkuPojo> binSkuPojoList = new ArrayList<>();
        for(BinSkuItemForm binSkuItemForm : binSkuItemFormList)
        {
            binSkuPojoList.add(convertBinSkuItemFormtoBinSkuPojo(binSkuItemForm,clientToGlobalSku.get(binSkuItemForm.getClientSkuId())));
        }
        return binSkuPojoList;

    }

    public static BinSkuPojo convertBinSkuItemFormtoBinSkuPojo(BinSkuItemForm binSkuItemForm, Long globalSkuId)
    {
        BinSkuPojo binSkuPojo = new BinSkuPojo();
        binSkuPojo.setBinId(binSkuItemForm.getBinId());
        binSkuPojo.setGlobalSkuId(globalSkuId);
        binSkuPojo.setQuantity(binSkuItemForm.getQuantity());
        return binSkuPojo;
    }

    public static List<InventoryPojo> convertBinSkuItemFormListToInventoryPojo(List<BinSkuItemForm> binSkuItemFormList,HashMap<String,Long> clientToGlobalSkuIdMap)
    {
        List<InventoryPojo> inventoryPojoList = new ArrayList<>();
        Map<String,Long> clientSkuIdToQuantityMap = binSkuItemFormList.stream().collect(groupingBy(BinSkuItemForm::getClientSkuId, summingLong(BinSkuItemForm::getQuantity)));
        for(String clientSkuId : clientSkuIdToQuantityMap.keySet())
        {
            InventoryPojo inventoryPojo = new InventoryPojo();
            inventoryPojo.setAvailableQuantity(clientSkuIdToQuantityMap.get(clientSkuId));
            inventoryPojo.setGlobalSkuId(clientToGlobalSkuIdMap.get(clientSkuId));
            inventoryPojoList.add(inventoryPojo);
        }
        return inventoryPojoList;
    }

    public static List<BinSkuData> convertBinSkuPojoListtoBinSkuData(List<BinSkuPojo> binSkuPojoList)
    {
        List<BinSkuData> binSkuDataList = new ArrayList<>();
        for(BinSkuPojo binSkuPojo : binSkuPojoList)
        {
            binSkuDataList.add(convertBinSkuPojotoBinSkuData(binSkuPojo));
        }
        return binSkuDataList;
    }

    public static BinSkuData convertBinSkuPojotoBinSkuData(BinSkuPojo binSkuPojo)
    {
        BinSkuData binSkuData = new BinSkuData();
        binSkuData.setBinId(binSkuPojo.getBinId());
        binSkuData.setGlobalSkuId(binSkuPojo.getGlobalSkuId());
        binSkuData.setQuantity(binSkuPojo.getQuantity());
        binSkuData.setId(binSkuPojo.getId());
        return binSkuData;
    }

    public static BinSkuPojo convertBinSkuUpdateFormtoBinSkuPojo(BinSkuUpdateForm binSkuUpdateForm, Long id)
    {
        BinSkuPojo binSkuPojo = new BinSkuPojo();
        binSkuPojo.setQuantity(binSkuUpdateForm.getQuantity());
        binSkuPojo.setId(id);
        return binSkuPojo;
    }

}
