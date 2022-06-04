package com.sonamik.hospital.service;

import com.sonamik.hospital.dto.DoctorDto;
import com.sonamik.hospital.dto.ServicingDto;
import com.sonamik.hospital.entity.Doctor;
import com.sonamik.hospital.entity.Servicing;
import com.sonamik.hospital.exeption.ResultNotFound;
import com.sonamik.hospital.mapper.DoctorMapper;
import com.sonamik.hospital.mapper.ServicingMapper;
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
    DoctorMapper doctorMapper;
    @Autowired
    ServicingRepo servicingRepo;
    @Autowired
    ServicingMapper servicingMapper;


    public Optional<DoctorDto> createDoctor(DoctorDto doctorDto) {
        Doctor doctorToSave=doctorMapper.toDoctor(doctorDto);
        Doctor doctorSaved=doctorRepo.save(doctorToSave);
        return Optional.of(doctorMapper.toDoctorDto(doctorSaved));
    }

    public Optional<DoctorDto> updateDoctor(Long id, DoctorDto doctorDto) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
        if (optionalDoctor.isEmpty()) {
            throw new ResultNotFound("Doctor with: " + id + " does not exist");
        }
        Doctor doc = optionalDoctor.get();
        Doctor docToSave=doctorMapper.toDoctor(doctorDto);
        doc.setName(docToSave.getName());
        doc.setSurname(docToSave.getSurname());
        doc.setDepartment(docToSave.getDepartment());
        return Optional.of(doctorMapper.toDoctorDto(doctorRepo.save(doc)));
    }

    public void deleteDoctor(long id) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
        if (optionalDoctor.isEmpty()) {
            throw new ResultNotFound("Doctor with: " + id + " does not exist");
        }
        doctorRepo.delete(optionalDoctor.get());
    }

    public Optional<ServicingDto> createServicing(ServicingDto servicingDto) {
        Servicing servicingToSave=servicingMapper.toServicing(servicingDto);
        Servicing servicingSaved=servicingRepo.save(servicingToSave);
        return Optional.of(servicingMapper.toServicingDto(servicingSaved));
    }

    public Optional<ServicingDto> updateServicing(Long id, ServicingDto servicingDto) {
        Optional<Servicing> optionalServicing = servicingRepo.findById(id);
        if (optionalServicing.isEmpty()) {
            throw new ResultNotFound("Service with: " + id + " does not exist");
        }
        Servicing serv = optionalServicing.get();
        Servicing servicingToSave=servicingMapper.toServicing(servicingDto);
        serv.setName(servicingToSave.getName());
        serv.setPrice(servicingToSave.getPrice());
        return Optional.of(servicingMapper.toServicingDto(servicingRepo.save(serv)));
    }

    public void deleteServicing(long id) {
        Optional<Servicing> optionalServicing = servicingRepo.findById(id);
        if (optionalServicing.isEmpty()) {
            throw new ResultNotFound("Service with: " + id + " does not exist");
        }
        servicingRepo.delete(optionalServicing.get());
    }
}
