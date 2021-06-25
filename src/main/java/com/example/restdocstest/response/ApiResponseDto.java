package com.example.restdocstest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class ApiResponseDto<T> {

    public static final ApiResponseDto<String> DEFAULT_OK = new ApiResponseDto<>(ApiResponseCode.OK);
    public static final ApiResponseDto<String> DEFAULT_UNAUTHORIZED = new ApiResponseDto<>(ApiResponseCode.UNAUTHORIZED);

    private ApiResponseCode code;
    private String message;
    private T data;

    private ApiResponseDto(ApiResponseCode status) {
        this.bindStatus(status);
    }

    private void bindStatus(ApiResponseCode status) {
        this.code = status;
        this.message = status.getMessage();
    }
}
