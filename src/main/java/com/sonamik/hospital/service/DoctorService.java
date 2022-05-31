package com.sonamik.hospital.service;

import com.sonamik.hospital.repo.StoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    StoryRepo storyRepo;
}
