package com.capgemini.polytech.mapper;

import com.capgemini.polytech.entite.ReservationEntity;
import com.capgemini.polytech.dto.ReservationDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ReservationMapper {
    ReservationDTO toDTO(ReservationEntity entity);
    ReservationEntity toEntity(ReservationDTO dto);
}