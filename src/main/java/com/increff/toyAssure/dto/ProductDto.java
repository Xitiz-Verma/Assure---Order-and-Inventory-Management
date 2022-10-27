package com.increff.toyAssure.dto;

import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.ProductData;
import com.increff.toyAssure.model.form.ProductForm;
import com.increff.toyAssure.api.ProductApi;
import com.increff.toyAssure.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.increff.toyAssure.dto.dtoHelper.ProductDtoHelper.*;
import static com.increff.toyAssure.pojo.TableConstants.MAX_LIST_SIZE;
import static com.increff.toyAssure.util.ValidationUtil.validateList;

@Service
public class ProductDto
{

    @Autowired
    private ProductApi productService;

    @Autowired
    private UserApi userService;

    public List<ProductData>getAll()
    {
        return convertProductPojoListtoProductDataList(productService.selectAll());
    }

    public ProductData getProductById(Long id)throws ApiException
    {
        return convertProductPojotoProductData(productService.selectById(id));
    }

    public void bulkAdd(List<ProductForm> productFormList, Long clientId)throws ApiException
    {
        validateList("ProductList",productFormList,MAX_LIST_SIZE);
        checkDuplicateProducts(productFormList);
        userService.getCheck(clientId);
        productService.bulkAdd(convertProductFormListtoProductPojoList(productFormList,clientId));
    }

    public void update(ProductForm productForm,Long  globalSkuId)throws ApiException
    {
        //validateForm()
        Long clientId = productService.selectById(globalSkuId).getClientId();
        productService.update(convertProductFormtoProductPojo(productForm,clientId),globalSkuId);

    }







}
