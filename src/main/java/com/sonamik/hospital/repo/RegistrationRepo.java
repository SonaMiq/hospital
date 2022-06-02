package com.sonamik.hospital.repo;

import com.sonamik.hospital.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface RegistrationRepo extends JpaRepository<Registration,Long> {
    List<Date> findByDoctorId(Long doctorID);
}
