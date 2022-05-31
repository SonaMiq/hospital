package com.sonamik.hospital.entity;

import javax.persistence.*;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @ManyToOne
     private Registration registration;
}
