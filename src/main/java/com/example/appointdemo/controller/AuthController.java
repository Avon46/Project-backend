package com.example.appointdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointdemo.dto.ApiResponse;
import com.example.appointdemo.dto.LoginRequest;
import com.example.appointdemo.dto.LoginResponse;
import com.example.appointdemo.security.JwtUtil;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {

        // 目前沒有使用者資料表，先用測試密碼
        // 之後可以改成查 DB
        if (!"123456".equals(request.getPassword())) {
            return ResponseEntity.ok(
                    ApiResponse.fail(null, "登入失敗"));
        }

        String token = jwtUtil.generateToken(request.getCathayNo());

        LoginResponse data = new LoginResponse(
                token,
                "Bearer",
                request.getCathayNo());

        return ResponseEntity.ok(
                ApiResponse.success(data, "登入成功"));
    }
}