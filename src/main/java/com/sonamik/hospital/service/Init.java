package com.sonamik.hospital.service;

import com.sonamik.hospital.entity.Doctor;
import com.sonamik.hospital.entity.DoctorAppointment;
import com.sonamik.hospital.repo.DoctorAppointmentRepo;
import com.sonamik.hospital.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Init {

    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    DoctorAppointmentRepo doctorAppointmentRepo;
    DoctorAppointment doctorAppointment;

    private static List<String> schedule=new ArrayList<String>();
    private void addTimes(){
        schedule.add("09:00");
        schedule.add("09:30");
        schedule.add("10:00");
        schedule.add("10:30");
        schedule.add("11:00");
        schedule.add("11:30");
        schedule.add("12:00");
        schedule.add("12:30");
        schedule.add("13:00");
        schedule.add("14:00");
        schedule.add("14:30");
        schedule.add("15:00");
        schedule.add("15:30");
        schedule.add("16:00");
        schedule.add("16:30");
        schedule.add("17:00");
        schedule.add("17:30");
        schedule.add("18:00");
    }
    public void addSchedule(){
        addTimes();
        Long doctorId;
       List<Doctor> doctors =doctorRepo.findAll();
        for (Doctor doctor:doctors) {
            doctorAppointment.setDoctor(doctor);
            for (int i = 0; i < schedule.size()-1; i++) {
                doctorAppointment.setStartTime(schedule.get(i));
                doctorAppointment.setEndTime(schedule.get(i+1));
            }
                 doctorAppointmentRepo.save(doctorAppointment);

        }
    }

    public static List<String> getSchedule() {
        return schedule;
    }
}
