package com.example.appointdemo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AppointQueryRequest {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
