package com.searchproducts.productsKotlinapi.model

import org.springframework.http.HttpStatus
import java.util.*

class ErrorMessage(val timestamp: Date,
                   val message: String?,
                   val status:HttpStatus )
