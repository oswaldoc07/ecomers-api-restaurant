package com.ecommerce.api.restaurants.web.controller;

import com.ecommerce.api.restaurants.domain.dto.ProductCategory;
import com.ecommerce.api.restaurants.domain.service.ProductCategoryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService service;
    @GetMapping()
    @ApiOperation("Get all categories of products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<ProductCategory>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/commerce/{id}")
    @ApiOperation("Get all categories of products by commerce")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<ProductCategory>> getAllbyCommerce(@PathVariable("id") int commerceId) {
        return new ResponseEntity<>(service.getAllByCommerce(commerceId), HttpStatus.OK);
    }


}



