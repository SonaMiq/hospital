package com.sonamik.hospital.repo;

import com.sonamik.hospital.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.sql.Date;


@Repository
public interface RegistrationRepo extends JpaRepository<Registration,Long> {
    Registration findRegistrationByDoctorIdAndRegDay(Long doctorID,Date regDay);
}
