package com.searchproducts.productsKotlinapi.model

data class Product (var productId:String,
                    var productName:String,
                    var categoryName:String) {

    var partsList = mutableListOf<Part>()
}


