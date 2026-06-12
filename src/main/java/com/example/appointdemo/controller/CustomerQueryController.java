package com.example.appointdemo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appointdemo.dto.ApiResponse;
import com.example.appointdemo.dto.AppointQueryRequest;
import com.example.appointdemo.dto.AppointQueryResponse;
import com.example.appointdemo.service.AppointService;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/customer")
public class CustomerQueryController {

    private final AppointService appointService;

    public CustomerQueryController(AppointService appointService) {
        this.appointService = appointService;
    }

    @PostMapping("/queryAppoint")
    public ResponseEntity<ApiResponse<List<AppointQueryResponse>>> queryAppoint(
            @RequestBody AppointQueryRequest request) {
        if (request == null || request.getStartTime() == null || request.getEndTime() == null) {
            return ResponseEntity.ok(
                    ApiResponse.fail(List.of(), "查詢區間不得為空值，請重新輸入"));
        }

        List<AppointQueryResponse> list = appointService.findUnfinishedAppoints(
                request.getStartTime(),
                request.getEndTime());

        return ResponseEntity.ok(
                ApiResponse.success(list, "查詢成功"));
    }
}