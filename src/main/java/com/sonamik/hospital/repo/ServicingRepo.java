package com.sonamik.hospital.repo;

import com.sonamik.hospital.entity.Servicing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicingRepo extends JpaRepository<Servicing,Long> {
}
