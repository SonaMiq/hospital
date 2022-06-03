package com.sonamik.hospital.service;

import com.sonamik.hospital.entity.Doctor;
import com.sonamik.hospital.entity.DoctorAppointment;
import com.sonamik.hospital.entity.Patient;
import com.sonamik.hospital.entity.Registration;
import com.sonamik.hospital.enums.AppointmentStatus;
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
    RegistrationRepo registrationRepo;
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    ServicingRepo servicingRepo;
    @Autowired
    DoctorAppointmentRepo doctorAppointmentRepo;

    public Patient createPatient(Patient patient) {
        Optional<Patient> optionalPatient = patientRepo.findByPhone(patient.getPhone());
        if (optionalPatient.isPresent()) {
            return optionalPatient.get();
        }
        return patientRepo.save(patient);
    }

    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
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


    public Registration register(Long doctorId, Long patientId, Long servicingId, Registration registration) {

        DoctorAppointment doctorAppointment = doctorAppointmentRepo.findByDoctorIdAndDateAndStartTime(doctorId, registration.getRegDay(), registration.getTime());
        doctorAppointment.setStatus(AppointmentStatus.BUSY);
        doctorAppointmentRepo.save(doctorAppointment);
        registration.setDoctor(doctorRepo.findById(doctorId).get());
        registration.setPatient(patientRepo.findById(patientId).get());
        registration.setServicing(servicingRepo.findById(servicingId).get());
        return registrationRepo.save(registration);
    }


}
