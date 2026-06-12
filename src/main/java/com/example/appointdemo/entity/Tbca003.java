package com.example.appointdemo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class Tbca003 {

    private Long sno;
    private String listNo;
    private String listCampcode;
    private LocalDateTime recallTime;
    private LocalDateTime recTime;
    private LocalDateTime updateTime;
    private String updateUser;
}