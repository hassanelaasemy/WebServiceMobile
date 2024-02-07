package com.smart.parking.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<?> handlerApiRequestException(ApiRequestException e){
        //create payload containing exception details
            HttpStatus badRequest = HttpStatus.BAD_REQUEST;
           ApiException apiException=new ApiException(
                  e.getMessage(),
                   badRequest,
                  ZonedDateTime.now(ZoneId.of("Z"))
          );
       //Return response entity
        return new ResponseEntity<>(apiException ,badRequest);
    }

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ResponseEntity<?> handlerApiRequestException(UsernameNotFoundException e){
        //create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException=new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        //Return response entity
        return new ResponseEntity<>(apiException ,badRequest);
    }
}
