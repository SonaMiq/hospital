package com.sonamik.hospital.controller;

import com.sonamik.hospital.service.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Start {

    @Autowired
    Init init;
    @PostMapping("/start")
    public void init(){
        init.addSchedule();
    }
}
