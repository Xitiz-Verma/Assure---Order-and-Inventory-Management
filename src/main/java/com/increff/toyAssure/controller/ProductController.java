package com.increff.toyAssure.controller;

import com.increff.toyAssure.dto.ProductDto;
import com.increff.toyAssure.exception.ApiException;
import com.increff.toyAssure.model.data.ProductData;
import com.increff.toyAssure.model.dataForUI.ProductDataUI;
import com.increff.toyAssure.model.form.ProductForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class ProductController
{
    @Autowired
    private ProductDto productDto;

    @ApiOperation(value = "Gets All Product Details")
    @RequestMapping(path = "/products",method = RequestMethod.GET)
    public List<ProductData> getProducts()
    {
        return productDto.getAll();
    }

    @ApiOperation(value = "Get Product by GlobalSkuId")
    @RequestMapping(path = "/products/{globalSkuId}", method = RequestMethod.GET)
    public ProductData getProductById(@PathVariable Long globalSkuId)throws ApiException
    {
        return productDto.getProductById(globalSkuId);
    }

    @ApiOperation(value = "Add Bulk Product Details")
    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public List<ProductDataUI> bulkAdd(@RequestBody List<ProductForm> productFormList, @RequestParam Long clientId)throws ApiException
    {
        return productDto.bulkAdd(productFormList,clientId);
    }

    @ApiOperation(value = "Update Product Details")
    @RequestMapping(path = "/products/{globalSkuId}", method = RequestMethod.PUT)
    public ProductDataUI update(@RequestBody ProductForm productForm, @PathVariable Long globalSkuId)throws ApiException
    {
        return productDto.update(productForm,globalSkuId);
    }
}
