package com.sonamik.hospital.dto;

import java.sql.Date;

public class RegistrationDto {
    private Long id;
    private Date regDay;
    private String time;

    public RegistrationDto() {

    }

    public RegistrationDto(Date regDay, String time) {
        this.regDay = regDay;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRegDay() {
        return regDay;
    }

    public void setRegDay(Date regDay) {
        this.regDay = regDay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
