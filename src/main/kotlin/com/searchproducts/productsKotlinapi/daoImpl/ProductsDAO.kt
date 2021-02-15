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

   val rowMapper :  RowMapper<Product>  = RowMapper<Product> {
       rs: ResultSet, rowNum: Int  ->  Product(
           rs.getInt("productId").toString(),
           rs.getString("productName"),
           rs.getString("categoryName")
        )
   }

    override fun getAllList(): List<Product> {
        return jdbcTemplate.query("SELECT * from products",rowMapper)
    }


}