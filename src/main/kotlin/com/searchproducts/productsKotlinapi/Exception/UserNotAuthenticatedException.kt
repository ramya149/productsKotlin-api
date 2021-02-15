package com.searchproducts.productsKotlinapi.Exception

import java.lang.RuntimeException

class UserNotAuthenticatedException(message:String) : RuntimeException(message) {
}