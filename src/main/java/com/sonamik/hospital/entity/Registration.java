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

}
