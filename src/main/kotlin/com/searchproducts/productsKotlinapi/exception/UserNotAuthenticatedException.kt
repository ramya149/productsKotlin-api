package com.searchproducts.productsKotlinapi.exception

import java.lang.RuntimeException

class UserNotAuthenticatedException(message:String) : RuntimeException(message) {
}