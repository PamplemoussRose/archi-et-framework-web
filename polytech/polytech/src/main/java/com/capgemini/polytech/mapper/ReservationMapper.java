package com.capgemini.polytech.mapper;

import com.capgemini.polytech.entite.ReservationEntity;
import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entite.ReservationId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ReservationMapper {

    /**
     * Convertit un objet {@link ReservationDTO} en une entité {@link ReservationEntity}.
     * La clé primaire composée de {@link ReservationId} est générée par la méthode
     * {@link #createReservationId(ReservationDTO)}.
     * Cette méthode est utilisée pour mapper un DTO de réservation en entité, où les informations
     * du DTO sont utilisées pour remplir les champs de l'entité, y compris la création de l'identifiant composite.
     *
     * @param dto l'objet {@link ReservationDTO} à convertir en entité.
     * @return l'entité {@link ReservationEntity} correspondante.
     */
    @Mapping(target = "reservationId", expression = "java(createReservationId(dto))")
    ReservationEntity toEntity(ReservationDTO dto);

    /**
     * Convertit une entité {@link ReservationEntity} en un objet DTO {@link ReservationDTO}.
     * Cette méthode est utilisée pour extraire les informations d'une entité de réservation et
     * les mapper dans un DTO. Les identifiants de l'utilisateur et du terrain sont extraits de
     * la clé primaire composée {@link ReservationId}.
     *
     * @param entity l'entité {@link ReservationEntity} à convertir en DTO.
     * @return l'objet {@link ReservationDTO} correspondant à l'entité.
     */
    @Mapping(target = "idUtilisateur", expression = "java(getUtilisateurId(entity))")
    @Mapping(target = "idTerrain", expression = "java(getTerrainId(entity))")
    ReservationDTO toDTO(ReservationEntity entity);

    /**
     * Crée un objet {@link ReservationId} à partir du DTO. Cette méthode est utilisée pour
     * générer l'identifiant composite à partir des champs `utilisateur_id` et `terrain_id`
     * présents dans le DTO. Ce générateur permet de créer une clé primaire composite pour
     * l'entité {@link ReservationEntity}.
     *
     * @param dto l'objet {@link ReservationDTO} contenant les informations nécessaires pour créer l'identifiant.
     * @return un objet {@link ReservationId} construit à partir des données du DTO.
     */
    default ReservationId createReservationId(ReservationDTO dto) {
        return new ReservationId(dto.getIdUtilisateur(), dto.getIdTerrain());
    }

    /**
     * Récupère l'identifiant de l'utilisateur à partir de l'entité {@link ReservationEntity}.
     * Cette méthode extrait l'identifiant de l'utilisateur de la clé primaire composite {@link ReservationId}.
     *
     * @param entity l'entité {@link ReservationEntity} à partir de laquelle l'identifiant utilisateur sera extrait.
     * @return l'identifiant de l'utilisateur contenu dans l'entité.
     */
    default int getUtilisateurId(ReservationEntity entity) {
        return entity.getReservationId().getUtilisateurId();
    }

    /**
     * Récupère l'identifiant du terrain à partir de l'entité {@link ReservationEntity}.
     * Cette méthode extrait l'identifiant du terrain de la clé primaire composite {@link ReservationId}.
     *
     * @param entity l'entité {@link ReservationEntity} à partir de laquelle l'identifiant du terrain sera extrait.
     * @return l'identifiant du terrain contenu dans l'entité.
     */
    default int getTerrainId(ReservationEntity entity) {
        return entity.getReservationId().getTerrainId();
    }
}
