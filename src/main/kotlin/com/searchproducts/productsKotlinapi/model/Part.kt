package com.searchproducts.productsKotlinapi.model

import com.fasterxml.jackson.annotation.JsonIgnore

data class Part(var punctuatedPartNumber: String, var partDesc: String,
                @JsonIgnore var productId: String, var originalRetailPrice: String,
                var brandName: String, var brandImage: String) {
}