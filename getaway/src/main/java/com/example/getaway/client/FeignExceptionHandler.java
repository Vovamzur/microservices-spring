package com.example.getaway.client;

import feign.FeignException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class FeignExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FeignException.BadRequest.class)
    public Map<String, Object> handleFeignStatusException(FeignException e) throws JSONException {
        return new JSONObject(e.contentUTF8()).toMap();
    }
}
