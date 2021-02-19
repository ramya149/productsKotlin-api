package com.searchproducts.productsKotlinapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal

data class  Part(val punctuatedPartNumber: String, val partDesc: String,
                @JsonIgnore val productId: Int, val originalRetailPrice: BigDecimal,
                val brandName: String, val brandImage: String)




