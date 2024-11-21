package com.capgemini.polytech.mapper;

import com.capgemini.polytech.entite.TerrainEntity;
import com.capgemini.polytech.dto.TerrainDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TerrainMapper {

    /**
     * Convertit une entité {@link TerrainEntity} en un objet DTO {@link TerrainDTO}.
     * Cette méthode est utilisée pour transférer les données de l'entité vers le DTO,
     * facilitant ainsi leur manipulation dans la couche de présentation ou la communication API.
     *
     * @param terrainEntity l'entité à convertir.
     * @return le DTO correspondant à l'entité.
     */
    TerrainDTO toDTO(TerrainEntity terrainEntity);

    /**
     * Convertit un objet DTO {@link TerrainDTO} en une entité {@link TerrainEntity}.
     * Cette méthode est utilisée pour mapper les données du DTO vers l'entité,
     * souvent lors de la création ou mise à jour d'une entité dans la base de données.
     *
     * @param terrainDTO le DTO à convertir.
     * @return l'entité correspondante au DTO.
     */
    TerrainEntity toEntity(TerrainDTO terrainDTO);
}
