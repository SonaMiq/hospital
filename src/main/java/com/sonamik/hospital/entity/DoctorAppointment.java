package com.sonamik.hospital.entity;

import com.sonamik.hospital.enums.AppointmentStatus;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class DoctorAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String startTime;
    private String endTime;
    @Enumerated(EnumType.ORDINAL)
    private AppointmentStatus status=AppointmentStatus.FREE;
    private Long doctorId;
    private Date date;

    public Integer getId() {
        return id;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
