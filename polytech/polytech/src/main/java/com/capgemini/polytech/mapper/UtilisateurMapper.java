package com.capgemini.polytech.mapper;

import com.capgemini.polytech.entite.UtilisateurEntity;
import com.capgemini.polytech.dto.UtilisateurDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UtilisateurMapper {

    /**
     * Convertit une entité {@link UtilisateurEntity} en un objet DTO {@link UtilisateurDTO}.
     * Cette méthode est utilisée pour transférer les données de l'entité vers le DTO,
     * facilitant ainsi leur manipulation dans la couche de présentation ou la communication API.
     *
     * @param utilisateurEntity l'entité à convertir.
     * @return le DTO correspondant à l'entité.
     */
    UtilisateurDTO toDTO(UtilisateurEntity utilisateurEntity);

    /**
     * Convertit un objet DTO {@link UtilisateurDTO} en une entité {@link UtilisateurEntity}.
     * Cette méthode est utilisée pour mapper les données du DTO vers l'entité,
     * souvent lors de la création ou mise à jour d'une entité dans la base de données.
     *
     * @param utilisateurDTO le DTO à convertir.
     * @return l'entité correspondante au DTO.
     */
    UtilisateurEntity toEntity(UtilisateurDTO utilisateurDTO);
}
