package com.example.appointdemo.dto;

import java.time.LocalDate;

public class WorkDateResponse {

    private LocalDate workDate;

    public WorkDateResponse() {
    }

    public WorkDateResponse(LocalDate workDate) {
        this.workDate = workDate;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }
}