package com.increff.toyAssure.dto.dtoHelper;

import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.ErrorData;
import com.increff.toyAssure.model.data.ProductData;
import com.increff.toyAssure.model.form.ProductForm;
import com.increff.toyAssure.pojo.ProductPojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.increff.toyAssure.util.ValidationUtil.throwErrorIfNotEmpty;

public class ProductDtoHelper
{

    public static List<ProductData> convertProductPojoListtoProductDataList(List<ProductPojo> productPojoList)
    {
        List<ProductData> productDataList = new ArrayList<>();
        for(ProductPojo productPojo : productPojoList)
        {
            productDataList.add(convertProductPojotoProductData(productPojo));
        }
        return productDataList;
    }

    public static ProductData convertProductPojotoProductData(ProductPojo productPojo)
    {
        ProductData productData = new ProductData();
        productData.setGlobalSkuId(productPojo.getGlobalSkuId());
        productData.setClientSkuId(productPojo.getClientSkuId());
        productData.setClientId(productPojo.getClientId());
        productData.setName(productPojo.getName());
        productData.setBrandId(productPojo.getBrandId());
        productData.setMrp(productPojo.getMrp());
        productData.setDescription(productPojo.getDescription());
        return productData;
    }



    public static List<ProductPojo> convertProductFormListtoProductPojoList(List<ProductForm> productFormList,Long clientId)
    {
        List<ProductPojo> productPojoList = new ArrayList<>();
        for(ProductForm productForm : productFormList)
        {
            productPojoList.add(convertProductFormtoProductPojo(productForm,clientId));
        }
        return productPojoList;
    }

    public static ProductPojo convertProductFormtoProductPojo(ProductForm productForm,Long clientId)
    {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setClientId(clientId);
        productPojo.setClientSkuId(productForm.getClientSkuId());
        productPojo.setName(productForm.getName());
        productPojo.setBrandId(productForm.getBrandId());
        productPojo.setMrp(productForm.getMrp());
        productPojo.setDescription(productForm.getDescription());
        return productPojo;
    }

    public static void checkDuplicateProducts(List<ProductForm> productFormList)throws ApiException
    {
        //Comparing bulkUploads via storing clientSkuid and ProductPojo in a HashSet
        HashSet<String> hashSet = new HashSet<>();
        List<ErrorData> errorDataList = new ArrayList<>();
        Long row = 1L;
        for(ProductForm productForm : productFormList)
        {
            if(hashSet.contains(productForm.getClientSkuId()))
            {
                errorDataList.add(new ErrorData(row,"Duplicate values of ClientSkuid " + productForm.getClientSkuId()));
            }
            hashSet.add(productForm.getClientSkuId());
            row++;
        }
        throwErrorIfNotEmpty(errorDataList);
    }

}
