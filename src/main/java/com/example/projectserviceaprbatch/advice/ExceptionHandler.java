package com.example.projectserviceaprbatch.advice;

import com.example.projectserviceaprbatch.dtos.ExceptionDto;
import com.example.projectserviceaprbatch.exceptions.ProductLimitReachedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class, NullPointerException.class})
    public ResponseEntity<String> handleException()
    {
        return new ResponseEntity<>("Something Went Wrong", HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(IndexOutOfBoundsException.class)
     public ResponseEntity<String> handleIndexedException()
     {
        return new ResponseEntity<>("Something Went Wrong", HttpStatus.NOT_FOUND);
     }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductLimitReachedException.class)
    public ResponseEntity<ExceptionDto> handleProductLimitReachedException()
    {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Custom Exception");
        exceptionDto.setErrorCode("PRODUCT_LIMIT_REACHED");
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
