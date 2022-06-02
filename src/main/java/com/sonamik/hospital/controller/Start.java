package com.sonamik.hospital.controller;

import com.sonamik.hospital.service.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Start {

    @Autowired
    Init init;
    @RequestMapping("/start")
    void init(){
        init.addSchedule();
    }
}
