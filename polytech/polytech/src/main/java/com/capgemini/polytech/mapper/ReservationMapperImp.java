package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entite.Reservation;

public class ReservationMapperImp implements ReservationMapper {
    @Override
    public ReservationDTO entiteToDto(Reservation entity) {
        if (entity == null) {
            return null;
        }
        ReservationDTO dto = new ReservationDTO();
        dto.setTerrainId(entity.getTerrainId());
        dto.setUtilisateurId(entity.getUtilisateurId());
        return dto;
    }

    @Override
    public Reservation dtoToEntite(ReservationDTO dto) {
        if (dto == null) {
            return null;
        }
        Reservation reservation = new Reservation();
        reservation.setTerrainId(dto.getTerrainId());
        reservation.setUtilisateurId(dto.getUtilisateurId());
        return reservation;
    }
}
