package com.sonamik.hospital.controller;

import com.sonamik.hospital.entity.Doctor;
import com.sonamik.hospital.entity.Servicing;
import com.sonamik.hospital.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("new/doctor")
    public Doctor createDoctor(@RequestBody Doctor doctor){
       return adminService.createDoctor(doctor);
    }
    @PostMapping("new/servising")
    public Servicing createServicing(@RequestBody Servicing servicing){
        return adminService.createServicing(servicing);
    }
}
