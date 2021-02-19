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
        if(header.isNotEmpty() && header == ("c90d1l3a-d088-43c4-bd19-1093af3048cf")) {
            return productService.getAllProducts()
            }
        else {
            throw UserNotAuthenticatedException("Send Valid API Key in request header")
        }

    }

}

/*To see if more than 1 class can be added to same kotlin file
* And to see the usage of IF block, if used as expression then else is mandatory*/
class Calculation(){
    fun calculation(){
        val someCondition = 40<35
        val num = if(someCondition){
            60
        }
        else{
            78
        }

        //val num = if(someCondition) 60 else 78

       /* if(someCondition){
            println("something")
        }*/
    }
}