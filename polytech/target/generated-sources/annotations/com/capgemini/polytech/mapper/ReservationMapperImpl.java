package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entite.ReservationEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationDTO toDTO(ReservationEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ReservationDTO.ReservationDTOBuilder reservationDTO = ReservationDTO.builder();

        reservationDTO.utilisateurId( entity.getUtilisateurId() );
        reservationDTO.terrainId( entity.getTerrainId() );
        reservationDTO.reservation( entity.getReservation() );

        return reservationDTO.build();
    }

    @Override
    public ReservationEntity toEntity(ReservationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ReservationEntity.ReservationEntityBuilder reservationEntity = ReservationEntity.builder();

        reservationEntity.utilisateurId( dto.getUtilisateurId() );
        reservationEntity.terrainId( dto.getTerrainId() );
        reservationEntity.reservation( dto.getReservation() );

        return reservationEntity.build();
    }
}
