package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.entite.TerrainEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class TerrainMapperImpl implements TerrainMapper {

    @Override
    public TerrainDTO toDTO(TerrainEntity terrainEntity) {
        if ( terrainEntity == null ) {
            return null;
        }

        TerrainDTO.TerrainDTOBuilder terrainDTO = TerrainDTO.builder();

        terrainDTO.nom( terrainEntity.getNom() );
        terrainDTO.quantite( terrainEntity.getQuantite() );
        terrainDTO.description( terrainEntity.getDescription() );
        terrainDTO.point_geo( terrainEntity.getPoint_geo() );

        return terrainDTO.build();
    }

    @Override
    public TerrainEntity toEntity(TerrainDTO terrainDTO) {
        if ( terrainDTO == null ) {
            return null;
        }

        TerrainEntity.TerrainEntityBuilder terrainEntity = TerrainEntity.builder();

        terrainEntity.nom( terrainDTO.getNom() );
        terrainEntity.quantite( terrainDTO.getQuantite() );
        terrainEntity.description( terrainDTO.getDescription() );
        terrainEntity.point_geo( terrainDTO.getPoint_geo() );

        return terrainEntity.build();
    }
}
