package com.searchproducts.productsKotlinapi.exception

import com.searchproducts.productsKotlinapi.model.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.util.*

@ControllerAdvice
class GlobalExceptionHandler {

    /* Handling Specific Exception*/
    @ExceptionHandler(DataNotFoundException::class)
    fun handleDataNotFoundException(exception:DataNotFoundException, request:WebRequest) : ResponseEntity<ErrorMessage>{
        val errorMessage = ErrorMessage(Date(),exception.message,HttpStatus.NOT_FOUND)
        return ResponseEntity(errorMessage,HttpStatus.NOT_FOUND)
    }

    /* Handling User Authentication Exception*/
    @ExceptionHandler(UserNotAuthenticatedException::class)
    fun handleNotAuthenticatedException(exception:UserNotAuthenticatedException, request:WebRequest) : ResponseEntity<ErrorMessage>{
        val errorMessage = ErrorMessage(Date(),exception.message,HttpStatus.UNAUTHORIZED)
        return ResponseEntity(errorMessage,HttpStatus.UNAUTHORIZED)
    }



    /* Handling generic Exception*/
    @ExceptionHandler(Exception::class)
    fun handleGenericException(exception:Exception, request:WebRequest) : ResponseEntity<ErrorMessage>{
        val errorMessage = ErrorMessage(Date(),exception.message,HttpStatus.INTERNAL_SERVER_ERROR)
        return ResponseEntity(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR)
    }

}