package com.example.appointdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private String returnCode;
    private T data;
    private String msg;

    public static <T> ApiResponse<T> success(T data, String msg) {
        return new ApiResponse<>("0", data, msg);
    }

    public static <T> ApiResponse<T> fail(T data, String msg) {
        return new ApiResponse<>("-1", data, msg);
    }
}