package com.capgemini.polytech.mapper;

import com.capgemini.polytech.entite.TerrainEntity;
import com.capgemini.polytech.dto.TerrainDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TerrainMapper {
    TerrainDTO toDTO(TerrainEntity terrainEntity);
    TerrainEntity toEntity(TerrainDTO terrainDTO);
}
