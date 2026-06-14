package com.example.appointdemo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "【員編】不得為空")
    private String cathayNo;

    @NotBlank(message = "【密碼】不得為空")
    private String password;
}