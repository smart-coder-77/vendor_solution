package com.smart.vendor.exception;

import com.smart.vendor.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Choudhury Subham on 21-06-2022
 */
@RestController
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = OrderIdNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleOrderIdNotFoundException(){
        ErrorDetails errorDetails= new ErrorDetails(404,"No Order available",new Date());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ProductIdNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleProductIdNotFoundException(){
        ErrorDetails errorDetails= new ErrorDetails(404,"No product available",new Date());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ProductNotSavedException.class)
    public ResponseEntity<ErrorDetails> handleProductNotSavedException(){
        ErrorDetails errorDetails= new ErrorDetails(400,"Product not saved ,Please enter valid product",new Date());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = OrderNotSavedException.class)
    public ResponseEntity<ErrorDetails> handleOrderNotSavedException(){
        ErrorDetails errorDetails= new ErrorDetails(400,"Order not created ,Please check the technical glitch",new Date());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
