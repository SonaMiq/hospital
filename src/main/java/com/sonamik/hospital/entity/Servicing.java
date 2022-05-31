package com.sonamik.hospital.entity;

import javax.persistence.*;

@Entity
public class Servicing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String name;
    private long price;

}
