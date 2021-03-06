package com.sonamik.hospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sonamik.hospital.enums.Department;
import com.sonamik.hospital.enums.Profession;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String surname;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Department department;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Profession profession;

   @OneToMany(mappedBy = "doctor")
    private Set<Registration> registrations;


    public Doctor(String name, String surname, Department department, Profession profession) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.profession = profession;
    }

    public Doctor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
