package com.example.restdocstest.api.advice;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorMessage {
    private String field;
    private String message;

    @Builder
    public ErrorMessage(String field,String message){
        this.field = field;
        this.message = message;
    }
}
