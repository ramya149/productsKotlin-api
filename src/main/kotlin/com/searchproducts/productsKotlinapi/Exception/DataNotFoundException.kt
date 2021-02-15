package com.searchproducts.productsKotlinapi.Exception

import java.lang.RuntimeException


class DataNotFoundException(message:String) : RuntimeException(message)  {
}