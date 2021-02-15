package com.searchproducts.productsKotlinapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal

data class Part(var punctuatedPartNumber: String, var partDesc: String,
                @JsonIgnore var productId: Int, var originalRetailPrice: BigDecimal,
                var brandName: String, var brandImage: String)
