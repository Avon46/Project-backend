package com.example.appointdemo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointdemo.dto.ApiResponse;
import com.example.appointdemo.dto.EmptyResponse;
import com.example.appointdemo.dto.UpdateAppointRequest;
import com.example.appointdemo.service.AppointService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/customer")
public class CustomerCommandController {

    private final AppointService appointService;

    public CustomerCommandController(AppointService appointService) {
        this.appointService = appointService;
    }

    @PostMapping("/updateAppoint")
    public ResponseEntity<ApiResponse<EmptyResponse>> updateAppoint(
            @RequestBody UpdateAppointRequest request) {
        try {
            ApiResponse<EmptyResponse> response = appointService.updateAppoint(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok(
                    ApiResponse.fail(new EmptyResponse(), e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(
                    ApiResponse.fail(new EmptyResponse(), "更新失敗"));
        }
    }
}
