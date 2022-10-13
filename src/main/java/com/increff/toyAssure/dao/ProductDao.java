package com.increff.toyAssure.dao;

import com.increff.toyAssure.pojo.ProductPojo;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDao extends AbstractDao
{

    private final static String SELECT_BY_GLOBAL_SKU_ID = "select p from ProductPojo p where globalSkuId=:globalSkuId";

    private final static String SELECT_BY_CLIENT_ID = "select p from ProductPojo p where clientId=:clientId";

    public List<ProductPojo> selectAll()
    {
        return selectAll(ProductPojo.class);
    }

    public ProductPojo selectById(Long globalSkuId)
    {
        TypedQuery<ProductPojo> query = em().createQuery(SELECT_BY_GLOBAL_SKU_ID,ProductPojo.class);
        query.setParameter("globalSkuId",globalSkuId);
        return (ProductPojo)getSingle(query);
    }

    public List<ProductPojo> selectByClientId(Long clientId)
    {
        TypedQuery<ProductPojo> query = em().createQuery(SELECT_BY_CLIENT_ID,ProductPojo.class);
        query.setParameter("clientId",clientId);
        return getMultiple(query);
    }

    public void add(ProductPojo productPojo)
    {
        addAbs(productPojo);
    }

    public void update()
    {
        //SYMBOLIC
    }
}
