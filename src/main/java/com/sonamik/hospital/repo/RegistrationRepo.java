package com.sonamik.hospital.repo;

import com.sonamik.hospital.entity.DoctorAppointment;
import com.sonamik.hospital.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface RegistrationRepo extends JpaRepository<Registration,Long> {
    @Query("select regDay from Registration where doctor.id=:doctorID")
    List<Date> findDatesByDoctorId(Long doctorID);
}
