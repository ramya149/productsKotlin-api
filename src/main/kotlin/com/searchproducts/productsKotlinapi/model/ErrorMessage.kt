package com.searchproducts.productsKotlinapi.model

import org.springframework.http.HttpStatus
import java.util.*

class ErrorMessage(var timestamp: Date,
                   var message: String?,
                   var status:HttpStatus ) {
}