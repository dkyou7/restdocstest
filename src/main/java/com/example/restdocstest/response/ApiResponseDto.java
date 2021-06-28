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



    private void bindStatus(ApiResponseCode status) {
        this.code = status;
        this.message = status.getMessage();
    }

    private ApiResponseDto(ApiResponseCode status) {
        this.bindStatus(status);
    }

    // createOK 와 관련있음
    private ApiResponseDto(ApiResponseCode status, T data) {
        this.bindStatus(status);
        this.data = data;
    }

    // createException 와 관련있음
    private ApiResponseDto(ApiResponseCode code, ApiException e) {
        this.code = code;
        this.message = e.getMessage();
    }

    // createException 와 관련있음 2
    private ApiResponseDto(ApiResponseCode code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponseDto<T> createOK(T data) {
        return new ApiResponseDto<>(ApiResponseCode.OK, data);
    }

    public static ApiResponseDto<String> createException(ApiException e) {
        return new ApiResponseDto<>(e.getStatus(), e);
    }

    public static ApiResponseDto<String> createException(ApiResponseCode code, String message) {
        return new ApiResponseDto<>(code, message, "");
    }

    public static <T> ApiResponseDto<T> createException(ApiResponseCode code, T data) {
        return new ApiResponseDto<>(code, data);
    }
}
