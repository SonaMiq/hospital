package com.sonamik.hospital.repo;

import com.sonamik.hospital.entity.DoctorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DoctorAppointmentRepo extends JpaRepository<DoctorAppointment, Integer> {
    //@Query("select start_time from doctor_appointment where doctor_Id=:doctorID and busy=0")
   // List<String> findFreeTime(Long doctorId);
    List<String> findByDoctorIdAndBusy(Long doctorId,Boolean busy);
    DoctorAppointment findByDoctorIdAndStartTime(Long doctorId,String startTime);
}
