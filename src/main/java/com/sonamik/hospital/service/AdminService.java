package com.sonamik.hospital.service;

import com.sonamik.hospital.repo.DoctorRepo;
import com.sonamik.hospital.repo.PatientRepo;
import com.sonamik.hospital.repo.RegistrationRepo;
import com.sonamik.hospital.repo.ServicingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    PatientRepo patientRepo;
    @Autowired
    RegistrationRepo registrationRepo;
    @Autowired
    ServicingRepo servicingRepo;
}
