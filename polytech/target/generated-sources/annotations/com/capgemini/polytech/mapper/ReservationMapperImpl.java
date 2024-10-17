package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entite.Reservation;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-17T11:12:26+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationDTO entiteToDto(Reservation entity) {
        if ( entity == null ) {
            return null;
        }

        ReservationDTO reservationDTO = new ReservationDTO();

        return reservationDTO;
    }

    @Override
    public Reservation dtoToEntite(ReservationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        return reservation;
    }
}
