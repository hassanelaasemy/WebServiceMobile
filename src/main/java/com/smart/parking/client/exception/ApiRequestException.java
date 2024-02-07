package com.smart.parking.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String message) {
        super(message);
    }

}
