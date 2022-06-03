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

    public List<String> getFreeTimes(Long doctorId, Date date) {
        if (!registrationRepo.findDatesByDoctorId(doctorId).contains(date)) {
            return doctorAppointmentRepo.findFreeTimes(doctorId,null);
        }

        return doctorAppointmentRepo.findFreeTimes(doctorId,date);
    }

    public Registration register(Long doctorId, Long patientId, Long servicingId, Registration registration) {
        DoctorAppointment doctorAppointment;
        if (!registrationRepo.findDatesByDoctorId(doctorId).contains(registration.getRegDay())){
            doctorAppointment=doctorAppointmentRepo.findByDoctorIdAndDateAndStartTime(doctorId,null, registration.getTime());
            doctorAppointment.setDate(registration.getRegDay());
        }
          else   doctorAppointment = doctorAppointmentRepo.findByDoctorIdAndDateAndStartTime(doctorId, registration.getRegDay(), registration.getTime());
        doctorAppointment.setStatus(AppointmentStatus.BUSY);
        doctorAppointmentRepo.save(doctorAppointment);
        registration.setDoctor(doctorRepo.findById(doctorId).get());
        registration.setPatient(patientRepo.findById(patientId).get());
        registration.setServicing(servicingRepo.findById(servicingId).get());
        registration.setDoctorAppointment(doctorAppointment);
        return registrationRepo.save(registration);
    }


}
