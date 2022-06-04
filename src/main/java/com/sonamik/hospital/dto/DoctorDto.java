package com.sonamik.hospital.dto;

import com.sonamik.hospital.enums.Department;
import com.sonamik.hospital.enums.Profession;

public class DoctorDto {

    private Long id;
    private String name;
    private String surname;
    private Department department;
    private Profession profession;

  public   DoctorDto(){

    }

    public DoctorDto(String name, String surname, Department department, Profession profession) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.profession = profession;
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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
