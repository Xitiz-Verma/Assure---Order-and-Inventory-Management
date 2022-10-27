package com.increff.toyAssure.dao;

import com.increff.toyAssure.pojo.BinPojo;
import com.increff.toyAssure.pojo.InventoryPojo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

@Repository
@Transactional
public class InventoryDao extends AbstractDao
{
    private final static String SELECT_BY_GLOBAL_SKU_ID = "select p from InventoryPojo where globalSkuId=:globalSkuId";

    public InventoryPojo selectByGlobalSkuId(Long globalSkuId)
    {
        TypedQuery<InventoryPojo> query = em().createQuery(SELECT_BY_GLOBAL_SKU_ID,InventoryPojo.class);
        query.setParameter("globalSkuId",globalSkuId);
        return (InventoryPojo) getSingle(query);
    }

    public void add(InventoryPojo inventoryPojo)
    {
        addAbs(inventoryPojo);
    }

    public void update()
    {

    }
}
