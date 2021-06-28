package com.example.restdocstest.response;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private ApiResponseCode status;
    private String message;

    public ApiException(ApiResponseCode status, Exception e) {
        super(e);
        this.status = status;
        this.message = status.getMessage();
    }
}
