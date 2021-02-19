package com.searchproducts.productsKotlinapi.daoImpl

import com.searchproducts.productsKotlinapi.dao.DAO
import com.searchproducts.productsKotlinapi.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class ProductsDAO( @Autowired val jdbcTemplate : JdbcTemplate) : DAO<Product>{

    /*I am using named arguments to call Product constructor. It is just to understand the concept */
   val rowMapper :  RowMapper<Product>  = RowMapper<Product> {
       rs: ResultSet, rowNum: Int  ->  Product(
           productName = rs.getString("productName"),
           categoryName = rs.getString("categoryName"),
           productId = rs.getInt("productId"),
        )
   }

    /*return keyword is removed as this function has just 1 line which is a expression.
    * This is called a function with expression body.
    * If function has curly braces and does more then 1 line, they are called function with block body*/
    override fun getAllList(): List<Product> =
            jdbcTemplate.query("SELECT * from products",rowMapper)



}