package com.sonamik.hospital.mapper;

import com.sonamik.hospital.dto.DoctorDto;
import com.sonamik.hospital.entity.Doctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {

    public Doctor toDoctor(DoctorDto doctorDto){
        Doctor doctor=new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setSurname(doctorDto.getSurname());
        doctor.setDepartment(doctorDto.getDepartment());
        doctor.setProfession(doctorDto.getProfession());
        return doctor;
    }
    public DoctorDto toDoctorDto(Doctor doctor){
        DoctorDto doctorDto=new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSurname(doctor.getSurname());
        doctorDto.setDepartment(doctor.getDepartment());
        doctorDto.setProfession(doctor.getProfession());
        return doctorDto;
    }
    public List<DoctorDto> mapAllToDoctorDto(List<Doctor> doctors){
       return doctors.stream().map(this::toDoctorDto).collect(Collectors.toList());

    }
}
