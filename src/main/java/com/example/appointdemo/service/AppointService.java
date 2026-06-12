package com.example.appointdemo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.appointdemo.dto.ApiResponse;
import com.example.appointdemo.dto.AppointQueryResponse;
import com.example.appointdemo.dto.EmptyResponse;
import com.example.appointdemo.dto.UpdateAppointRequest;
import com.example.appointdemo.mapper.AppointMapper;

@Service
public class AppointService {

    private static final Logger log = LoggerFactory.getLogger(AppointService.class);

    private final AppointMapper appointMapper;

    public AppointService(AppointMapper appointMapper) {
        this.appointMapper = appointMapper;
    }

    public List<AppointQueryResponse> findUnfinishedAppoints(
            LocalDateTime startTime,
            LocalDateTime endTime) {
        return appointMapper.findUnfinishedAppoints(startTime, endTime);
    }

    public ApiResponse<EmptyResponse> updateAppoint(UpdateAppointRequest request) {
        if (request == null || request.getSno() == null) {
            throw new IllegalArgumentException("【流水號】不得為空");
        }

        if (request.getRecallTime() == null) {
            throw new IllegalArgumentException("【約訪時間設定值】不得為空");
        }

        // TODO 正式版需改為當前登入者員編 CathayNo
        String updateUser = "TEST_USER";

        try {
            int updatedCount = appointMapper.updateAppoint(
                    request.getSno(),
                    request.getRecallTime(),
                    updateUser);

            if (updatedCount == 1) {
                return ApiResponse.success(new EmptyResponse(), "更新成功");
            }

            return ApiResponse.fail(new EmptyResponse(), "更新失敗");

        } catch (Exception e) {
            log.error("異動約訪記錄檔失敗，sno={}", request.getSno(), e);
            return ApiResponse.fail(new EmptyResponse(), "更新失敗");
        }
    }
}