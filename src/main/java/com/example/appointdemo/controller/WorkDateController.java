package com.example.appointdemo.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.appointdemo.dto.ApiResponse;
import com.example.appointdemo.dto.WorkDateRequest;
import com.example.appointdemo.dto.WorkDateResponse;
import com.example.appointdemo.service.WorkDateService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/workdate")
public class WorkDateController {

    private final WorkDateService workDateService;

    public WorkDateController(WorkDateService workDateService) {
        this.workDateService = workDateService;
    }

    @PostMapping("/getCXLXWorkingDate")
    public ResponseEntity<ApiResponse<WorkDateResponse>> getCXLXWorkingDate(
            @RequestBody WorkDateRequest request) {
        try {
            LocalDate workDate = workDateService.getWorkingDate(request);

            return ResponseEntity.ok(
                    ApiResponse.success(new WorkDateResponse(workDate), "查詢成功"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok(
                    ApiResponse.fail(new WorkDateResponse(), e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(
                    ApiResponse.fail(new WorkDateResponse(), "工作天查詢失敗"));
        }
    }
}