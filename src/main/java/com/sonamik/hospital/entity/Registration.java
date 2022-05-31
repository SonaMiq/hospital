package com.sonamik.hospital.entity;

import com.sonamik.hospital.repo.PatientRepo;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date regDay;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Servicing servicing;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getRegDay() {
        return regDay;
    }

    public void setRegDay(Date regDay) {
        this.regDay = regDay;
    }

    public Servicing getServicing() {
        return servicing;
    }

    public void setServicing(Servicing servicing) {
        this.servicing = servicing;
    }
}

