package com.example.appointdemo.service;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.appointdemo.dto.WorkDateRequest;

@Service
public class WorkDateService {

    public LocalDate getWorkingDate(WorkDateRequest request) {
        if (request == null || request.getTheDATE() == null) {
            throw new IllegalArgumentException("【基準日期】不得為空");
        }

        if (request.getDAY() == null) {
            throw new IllegalArgumentException("【天數】不得為空");
        }

        if (request.getDAY() < 0) {
            throw new IllegalArgumentException("【天數】不得小於 0");
        }

        if (request.getDIRECTION() == null) {
            throw new IllegalArgumentException("【方向】不得為空");
        }

        LocalDate result = request.getTheDATE();
        int remainingDays = request.getDAY();

        while (remainingDays > 0) {
            if (request.getDIRECTION()) {
                result = result.plusDays(1);
            } else {
                result = result.minusDays(1);
            }

            if (isWorkingDay(result)) {
                remainingDays--;
            }
        }

        return result;
    }

    private boolean isWorkingDay(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek != DayOfWeek.SATURDAY
                && dayOfWeek != DayOfWeek.SUNDAY;
    }
}