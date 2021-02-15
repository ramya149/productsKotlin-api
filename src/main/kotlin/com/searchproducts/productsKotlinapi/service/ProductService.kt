package com.searchproducts.productsKotlinapi.service

import com.searchproducts.productsKotlinapi.exception.DataNotFoundException
import com.searchproducts.productsKotlinapi.daoImpl.PartsDAO
import com.searchproducts.productsKotlinapi.daoImpl.ProductsDAO
import com.searchproducts.productsKotlinapi.model.Part
import com.searchproducts.productsKotlinapi.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class ProductService(@Autowired val productDaoImpl : ProductsDAO,
                     @Autowired val partDaoImpl : PartsDAO) {

    var productsList = listOf<Product>()
    var partsList = listOf<Part>()

    /*To load all products with parts embedded */
    fun getAllProducts() : List<Product> {
        productsList = productDaoImpl.getAllList()
        if(productsList.isNotEmpty()){
            partsList = getAllParts()
            if(partsList.isNotEmpty()) {
                addPartsToProducts(productsList, partsList)
            }
            return productsList
        }
        else {
            throw DataNotFoundException("No products found")
        }

    }

    /* To fetch all Parts*/
    fun getAllParts() : List<Part> {
        return partDaoImpl.getAllList()
    }

    /*To iterate over the Parts List and map them to respective Products by comparing the ProductId */
    fun addPartsToProducts(productsList: List<Product>, partsList: List<Part>): List<Product> {
        for (product in productsList) {
            val newPartsList: MutableList<Part> = ArrayList()
            for (part in partsList) {
                if (part.productId.equals(product.productId)) {
                    newPartsList.add(part)
                }
            }
            product.partsList.addAll(newPartsList)
        }
        return productsList
    }

}
