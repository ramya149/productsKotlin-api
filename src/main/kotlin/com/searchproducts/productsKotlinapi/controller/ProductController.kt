package com.searchproducts.productsKotlinapi.controller

import com.searchproducts.productsKotlinapi.exception.UserNotAuthenticatedException
import com.searchproducts.productsKotlinapi.model.Product
import com.searchproducts.productsKotlinapi.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(@Autowired val productService : ProductService) {

    @RequestMapping("/products")
    fun getAllProducts(@RequestHeader("Lemans-Api-Key") header:String): List<Product>{
        if(header.isNotEmpty() && header.equals("c90d1l3a-d088-43c4-bd19-1093af3048cf")) {
            return productService.getAllProducts()
            }
        else {
            throw UserNotAuthenticatedException("Send Valid API Key in request header")
        }
    }

}