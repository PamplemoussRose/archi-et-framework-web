package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entite.Reservation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ReservationMapperIntegrationTest {

    private ReservationMapper reservationMapper = new ReservationMapperImp();

    @Test
    void entiteToDto() {
        Reservation reservation = new Reservation();
        reservation.setReservation(123);
        reservation.setUtilisateurId(321);
        reservation.setTerrainId(231);

        ReservationDTO reservationDTO = reservationMapper.entiteToDto(reservation);

        assertNotNull(reservationDTO);
        assertEquals(reservationDTO.getTerrainId(), reservation.getTerrainId());
        assertEquals(reservationDTO.getUtilisateurId(), reservation.getUtilisateurId());
    }

    @Test
    void dtoToEntite() {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setUtilisateurId(321);
        reservationDTO.setTerrainId(231);

        Reservation reservation = reservationMapper.dtoToEntite(reservationDTO);

        assertNotNull(reservation);
        assertEquals(reservation.getTerrainId(), reservationDTO.getTerrainId());
        assertEquals(reservation.getUtilisateurId(), reservationDTO.getUtilisateurId());
    }
}