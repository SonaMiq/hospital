package com.sonamik.hospital.service;

import com.sonamik.hospital.entity.Doctor;
import com.sonamik.hospital.entity.DoctorAppointment;
import com.sonamik.hospital.entity.Patient;
import com.sonamik.hospital.entity.Registration;
import com.sonamik.hospital.repo.DoctorAppointmentRepo;
import com.sonamik.hospital.repo.DoctorRepo;
import com.sonamik.hospital.repo.PatientRepo;
import com.sonamik.hospital.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<String> getFreeTimes(Long doctorId, Date date, String time) {
        if (!registrationRepo.findByDoctorId(doctorId).contains(date)) {
            return Init.getSchedule();
        }
        return doctorAppointmentRepo.findByDoctorIdAndBusy(doctorId,false);
    }

    public Registration register(Registration registration) {
        DoctorAppointment doctorAppointment = doctorAppointmentRepo.findByDoctorIdAndStartTime(registration.getDoctor().getId(), registration.getTime());
        doctorAppointment.setBusy(true);
        doctorAppointmentRepo.save(doctorAppointment);
        return registrationRepo.save(registration);
    }


}
