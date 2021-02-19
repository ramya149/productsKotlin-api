package com.searchproducts.productsKotlinapi.model

data class Product (val productId:Int,
                    val productName:String,
                    val categoryName:String) {

    val partsList = arrayListOf<Part>()

}





