package com.sonamik.hospital.service;

import com.sonamik.hospital.dto.DoctorDto;
import com.sonamik.hospital.dto.PatientDto;
import com.sonamik.hospital.dto.RegistrationDto;
import com.sonamik.hospital.entity.Doctor;
import com.sonamik.hospital.entity.DoctorAppointment;
import com.sonamik.hospital.entity.Patient;
import com.sonamik.hospital.entity.Registration;
import com.sonamik.hospital.enums.AppointmentStatus;
import com.sonamik.hospital.mapper.DoctorMapper;
import com.sonamik.hospital.mapper.PatientMapper;
import com.sonamik.hospital.mapper.RegistrationMapper;
import com.sonamik.hospital.mapper.ServicingMapper;
import com.sonamik.hospital.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    PatientRepo patientRepo;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    RegistrationRepo registrationRepo;
    @Autowired
    RegistrationMapper registrationMapper;
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    ServicingRepo servicingRepo;
    @Autowired
    ServicingMapper servicingMapper;
    @Autowired
    DoctorAppointmentRepo doctorAppointmentRepo;

    public Optional<PatientDto> createPatient(PatientDto patientDto) {
        Patient patientToSave=patientMapper.toPatient(patientDto);
        Optional<Patient> optionalPatient = patientRepo.findByPhone(patientToSave.getPhone());
        if (optionalPatient.isPresent()) {
            return Optional.of(patientMapper.toPatientDto(optionalPatient.get()));
        }
        return Optional.of(patientMapper.toPatientDto(patientRepo.save(patientToSave)));
    }

    public List<DoctorDto> getDoctors() {
        return doctorMapper.mapAllToDoctorDto(doctorRepo.findAll());
    }

    public List<DoctorAppointment> getFreeTimes(Long doctorId, Date date) {
        Registration registration = registrationRepo.findRegistrationByDoctorIdAndRegDay(doctorId, date);
        if (registration == null) {
            int time = 9;
            while (time < 18) {
                if (time == 13) {
                    time++;
                }
                DoctorAppointment doctorAppointment = new DoctorAppointment();
                doctorAppointment.setDoctorId(doctorId);
                doctorAppointment.setDate(date);
                doctorAppointment.setStartTime(time + ":00");
                doctorAppointment.setEndTime(time + ":30");
                doctorAppointmentRepo.save(doctorAppointment);
                time++;
            }
        }

        return doctorAppointmentRepo.findDoctorAppointmentByDoctorIdAndDateAndStatus(doctorId, date, AppointmentStatus.FREE);

    }


    public Optional<RegistrationDto> register(Long doctorId, Long patientId, Long servicingId, RegistrationDto registrationDto) {

        DoctorAppointment doctorAppointment = doctorAppointmentRepo.findByDoctorIdAndDateAndStartTime(doctorId, registrationDto.getRegDay(), registrationDto.getTime());
        doctorAppointment.setStatus(AppointmentStatus.BUSY);
        doctorAppointmentRepo.save(doctorAppointment);
        Registration registrationToSave=registrationMapper.toRegistration(registrationDto);
        registrationToSave.setDoctor(doctorRepo.findById(doctorId).get());
        registrationToSave.setPatient(patientRepo.findById(patientId).get());
        registrationToSave.setServicing(servicingRepo.findById(servicingId).get());
        return Optional.of(registrationMapper.toRegistrationDto(registrationRepo.save(registrationToSave)));
    }


}
