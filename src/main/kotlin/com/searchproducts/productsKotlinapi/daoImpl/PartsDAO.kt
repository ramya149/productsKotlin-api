package com.searchproducts.productsKotlinapi.daoImpl

import com.searchproducts.productsKotlinapi.dao.DAO
import com.searchproducts.productsKotlinapi.model.Part
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class PartsDAO( @Autowired val jdbcTemplate : JdbcTemplate) : DAO<Part>{


    val rowMapper :  RowMapper<Part>  = RowMapper<Part> {
        rs: ResultSet, rowNum: Int  ->  Part(
            rs.getString("punctuatedPartNumber"),
            rs.getString("partDescr"),
            rs.getInt("productId"),
            rs.getBigDecimal("originalRetailPrice"),
            rs.getString("brandName"),
            rs.getString("brandImage")

    )
    }

    override fun getAllList(): List<Part> {
        return jdbcTemplate.query("SELECT * from parts",rowMapper)
    }


}