package com.sonamik.hospital.service;

import com.sonamik.hospital.entity.Doctor;
import com.sonamik.hospital.entity.Servicing;
import com.sonamik.hospital.exeption.ResultNotFound;
import com.sonamik.hospital.repo.DoctorRepo;
import com.sonamik.hospital.repo.ServicingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    ServicingRepo servicingRepo;

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
        if (optionalDoctor.isEmpty()) {
            throw new ResultNotFound("Doctor with: " + id + " does not exist");
        }
        Doctor doc = optionalDoctor.get();
        doc.setName(doctor.getName());
        doc.setSurname(doctor.getSurname());
        doc.setDepartment(doctor.getDepartment());
        return doctorRepo.save(doc);
    }

    public void deleteDoctor(long id) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
        if (optionalDoctor.isEmpty()) {
            throw new ResultNotFound("Doctor with: " + id + " does not exist");
        }
        doctorRepo.delete(optionalDoctor.get());
    }

    public Servicing createServicing(Servicing servicing) {
        return servicingRepo.save(servicing);
    }

    public Servicing updateServicing(long id, Servicing servicing) {
        Optional<Servicing> optionalServicing = servicingRepo.findById(id);
        if (optionalServicing.isEmpty()) {
            throw new ResultNotFound("Service with: " + id + " does not exist");
        }
        Servicing serv = optionalServicing.get();
        serv.setName(servicing.getName());
        serv.setPrice(servicing.getPrice());
        return servicingRepo.save(servicing);
    }

    public void deleteServicing(long id) {
        Optional<Servicing> optionalServicing = servicingRepo.findById(id);
        if (optionalServicing.isEmpty()) {
            throw new ResultNotFound("Service with: " + id + " does not exist");
        }
        servicingRepo.delete(optionalServicing.get());
    }
}
