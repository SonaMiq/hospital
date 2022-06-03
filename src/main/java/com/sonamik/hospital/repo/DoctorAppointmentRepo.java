package com.sonamik.hospital.repo;

import com.sonamik.hospital.entity.DoctorAppointment;
import com.sonamik.hospital.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;


public interface DoctorAppointmentRepo extends JpaRepository<DoctorAppointment, Integer> {
    @Query("select startTime from DoctorAppointment where doctorId=:doctorId and date=:date and status=0" )
    List<String> findFreeTimes(Long doctorId,Date date);
    DoctorAppointment findByDoctorIdAndDateAndStartTime(Long doctorId, Date date,String startTime);


}
