package com.sonamik.hospital.repo;

import com.sonamik.hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {

}
