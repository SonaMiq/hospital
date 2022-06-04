package com.sonamik.hospital.mapper;

import com.sonamik.hospital.dto.RegistrationDto;
import com.sonamik.hospital.entity.Registration;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper {

    public Registration toRegistration(RegistrationDto registrationDto) {
        Registration registration = new Registration();
        registration.setId(registrationDto.getId());
        return registration;
    }

    public RegistrationDto toRegistrationDto(Registration registration) {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setId(registrationDto.getId());
        return registrationDto;
    }
}
