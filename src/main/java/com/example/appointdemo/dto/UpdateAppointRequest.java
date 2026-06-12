package com.example.appointdemo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UpdateAppointRequest {

    private Long sno;
    private LocalDateTime recallTime;
}