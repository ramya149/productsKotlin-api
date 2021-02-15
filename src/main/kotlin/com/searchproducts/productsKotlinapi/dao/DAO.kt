package com.searchproducts.productsKotlinapi.dao

interface DAO<T> {

    fun getAllList() : List<T>

}