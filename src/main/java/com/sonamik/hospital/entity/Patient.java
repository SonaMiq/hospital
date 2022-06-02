package com.sonamik.hospital.entity;

import com.sonamik.hospital.enums.BloodGroup;
import com.sonamik.hospital.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 30)
    private String surname;
    @Min(0)
    @Max(120)
    private Integer age;
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    @Enumerated(EnumType.ORDINAL)
    private BloodGroup bloodGroup;
    private String phone;

    @OneToMany(mappedBy = "patient")
    private Set<Registration> registrations;

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


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

