package com.example.appointdemo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AppointQueryResponse {

    private Long sno;
    private String listNo;
    private String campName;
    private String custName;
    private LocalDateTime recallTime;
    private String listLastphone;
    private LocalDate campServiceDt;
}