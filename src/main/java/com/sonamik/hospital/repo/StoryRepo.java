package com.sonamik.hospital.repo;

import com.sonamik.hospital.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepo extends JpaRepository<Story,Long> {
}
