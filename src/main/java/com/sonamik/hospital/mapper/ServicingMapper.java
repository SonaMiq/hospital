package com.sonamik.hospital.mapper;

import com.sonamik.hospital.dto.ServicingDto;
import com.sonamik.hospital.entity.Servicing;
import org.springframework.stereotype.Component;

@Component
public class ServicingMapper {

    public Servicing toServicing(ServicingDto servicingDto) {
        Servicing servicing = new Servicing();
        servicing.setId(servicingDto.getId());
        servicing.setName(servicingDto.getName());
        servicing.setPrice(servicingDto.getPrice());
        return servicing;
    }

    public ServicingDto toServicingDto(Servicing servicing) {

        ServicingDto servicingDto = new ServicingDto();
        servicingDto.setId(servicing.getId());
        servicingDto.setName(servicing.getName());
        servicingDto.setPrice(servicingDto.getPrice());
        return servicingDto;
    }
}
