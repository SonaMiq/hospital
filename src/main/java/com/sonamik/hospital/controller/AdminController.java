package com.sonamik.hospital.controller;

import com.sonamik.hospital.dto.DoctorDto;
import com.sonamik.hospital.dto.ServicingDto;
import com.sonamik.hospital.entity.Doctor;
import com.sonamik.hospital.entity.Servicing;
import com.sonamik.hospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("new/doctor")
    public Optional<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
       return adminService.createDoctor(doctorDto);
    }
    @PostMapping("new/servising")
    public Optional<ServicingDto> createServicing(@RequestBody ServicingDto servicingDto){
        return adminService.createServicing(servicingDto);
    }
}
