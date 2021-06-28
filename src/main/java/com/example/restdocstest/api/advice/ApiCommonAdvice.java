package com.example.restdocstest.api.advice;

import com.example.restdocstest.api.controller.PersonController;
import com.example.restdocstest.response.ApiException;
import com.example.restdocstest.response.ApiResponseCode;
import com.example.restdocstest.response.ApiResponseDto;
import lombok.extern.slf4j.Slf4j;
import javax.validation.ConstraintViolationException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order(value = 1)
@RestControllerAdvice(basePackageClasses = {PersonController.class})
public class ApiCommonAdvice {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler
    public ApiResponseDto<String> handleBaseException(ApiException e){
        return ApiResponseDto.createException(e);
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({ConstraintViolationException.class})
    public ApiResponseDto<String> handleBaseException(ConstraintViolationException e) {

        return ApiResponseDto.createException(ApiResponseCode.BAD_PARAMETER, "파라미터가 잘못됐습니다.");
    }
}
