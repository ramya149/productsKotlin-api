package com.searchproducts.productsKotlinapi.model

data class Product (var productId:Int,
                    var productName:String,
                    var categoryName:String) {

    var partsList = mutableListOf<Part>()
}


