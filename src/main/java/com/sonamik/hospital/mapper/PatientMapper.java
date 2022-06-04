package com.sonamik.hospital.mapper;

import com.sonamik.hospital.dto.PatientDto;
import com.sonamik.hospital.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toPatient(PatientDto patientDto){
        Patient patient=new Patient();
        patient.setId(patientDto.getId());
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setAge(patientDto.getAge());
        patient.setGender(patientDto.getGender());
        patient.setBloodGroup(patientDto.getBloodGroup());
        patient.setPhone(patientDto.getPhone());
        return patient;
    }

    public PatientDto toPatientDto(Patient patient){
        PatientDto patientDto=new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setSurname(patient.getSurname());
        patientDto.setAge(patient.getAge());
        patientDto.setGender(patient.getGender());
        patientDto.setBloodGroup(patient.getBloodGroup());
        patientDto.setPhone(patient.getPhone());
        return patientDto;
    }
}
