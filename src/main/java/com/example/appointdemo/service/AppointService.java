package com.example.appointdemo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public ApiResponse<EmptyResponse> updateAppoint(
            UpdateAppointRequest request,
            String updateUser) {
        if (request == null || request.getSno() == null) {
            throw new IllegalArgumentException("【流水號】不得為空");
        }

        if (request.getRecallTime() == null) {
            throw new IllegalArgumentException("【約訪時間設定值】不得為空");
        }

        if (updateUser == null || updateUser.isBlank()) {
            throw new IllegalArgumentException("【更新人員】不得為空");
        }

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
            log.error("異動約訪記錄檔失敗，sno={}, updateUser={}",
                    request.getSno(), updateUser, e);
            return ApiResponse.fail(new EmptyResponse(), "更新失敗");
        }
    }
}
