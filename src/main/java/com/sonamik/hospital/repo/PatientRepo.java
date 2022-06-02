package com.sonamik.hospital.repo;

import com.sonamik.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {
    Optional<Patient> findByPhone(String phone);
}
