package com.capgemini.polytech.mapper;

import com.capgemini.polytech.entite.Reservation;
import com.capgemini.polytech.dto.ReservationDTO;

public interface ReservationMapper {
    public ReservationDTO entiteToDto(Reservation entity);
    public Reservation dtoToEntite(ReservationDTO dto);
}