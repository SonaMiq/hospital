package com.sonamik.hospital.repo;

import com.sonamik.hospital.entity.DoctorAppointment;
import com.sonamik.hospital.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;


public interface DoctorAppointmentRepo extends JpaRepository<DoctorAppointment, Integer> {
    List<DoctorAppointment> findDoctorAppointmentByDoctorIdAndDateAndStatus(Long doctorId, Date date, AppointmentStatus appointmentStatus);
    DoctorAppointment findByDoctorIdAndDateAndStartTime(Long doctorId,Date date,String startTime);



}
