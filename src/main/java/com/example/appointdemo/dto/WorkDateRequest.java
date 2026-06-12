package com.example.appointdemo.dto;

import java.time.LocalDate;

public class WorkDateRequest {

    private LocalDate theDATE;
    private Integer DAY;
    private Boolean DIRECTION;

    public LocalDate getTheDATE() {
        return theDATE;
    }

    public void setTheDATE(LocalDate theDATE) {
        this.theDATE = theDATE;
    }

    public Integer getDAY() {
        return DAY;
    }

    public void setDAY(Integer DAY) {
        this.DAY = DAY;
    }

    public Boolean getDIRECTION() {
        return DIRECTION;
    }

    public void setDIRECTION(Boolean DIRECTION) {
        this.DIRECTION = DIRECTION;
    }
}