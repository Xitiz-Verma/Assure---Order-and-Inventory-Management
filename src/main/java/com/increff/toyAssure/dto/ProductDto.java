package com.increff.toyAssure.dto;

import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.ProductData;
import com.increff.toyAssure.model.dataForUI.ProductDataUI;
import com.increff.toyAssure.model.form.ProductForm;
import com.increff.toyAssure.pojo.ProductPojo;
import com.increff.toyAssure.service.ProductService;
import com.increff.toyAssure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.increff.toyAssure.dto.dtoHelper.ProductDtoHelper.*;
import static com.increff.toyAssure.pojo.TableConstants.MAX_LIST_SIZE;
import static com.increff.toyAssure.util.ValidationUtil.validateList;
import static java.util.Objects.isNull;

@Service
public class ProductDto
{

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public List<ProductData>getAll()
    {
        return convertProductPojoListtoProductDataList(productService.selectAll());
    }

    public ProductData getProductById(Long id)throws ApiException
    {
        return convertProductPojotoProductData(productService.selectById(id));
    }

    public List<ProductDataUI> bulkAdd(List<ProductForm> productFormList, Long clientId)throws ApiException
    {
        validateList("ProductList",productFormList,MAX_LIST_SIZE);
        checkDuplicateProducts(productFormList);
        if(isNull(userService.selectByUserId(clientId)))
        {
            throw new ApiException("ClientId does not exist");
        }
        productService.bulkAdd(convertProductFormListtoProductPojoList(productFormList,clientId));
        return convertProductFormListtoProductDataUIList(productFormList);
    }

    public ProductDataUI update(ProductForm productForm,Long  globalSkuId)throws ApiException
    {
        //validateForm()
        Long clientId = productService.selectById(globalSkuId).getClientId();
        productService.update(convertProductFormtoProductPojo(productForm,clientId),globalSkuId);
        return convertProductFormtoProductDataUI(productForm);

    }







}
