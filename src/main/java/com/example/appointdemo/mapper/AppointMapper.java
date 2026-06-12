package com.example.appointdemo.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.appointdemo.dto.AppointQueryResponse;

@Mapper
public interface AppointMapper {

    List<AppointQueryResponse> findUnfinishedAppoints(
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);

    int updateAppoint(
            @Param("sno") Long sno,
            @Param("recallTime") LocalDateTime recallTime,
            @Param("updateUser") String updateUser);
}
