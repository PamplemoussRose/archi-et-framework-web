package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.entite.TerrainEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerrainMapperTest {

    private TerrainMapper terrainMapper = new TerrainMapperImpl();

    @Test
    void toDTO() {
        TerrainEntity terrainEntity = TerrainEntity.builder()
                .id(42)
                .nom("Parc")
                .quantite(10)
                .description("Un parc pour loisirs")
                .point_geo("45.75,4.85")
                .build();
        TerrainDTO terrainDTO = terrainMapper.toDTO(terrainEntity);

        assertEquals(42, terrainDTO.getId());
    }

    @Test
    void toEntity() {
        TerrainDTO terrainDTO = TerrainDTO.builder()
                .id(42)
                .nom("Parc")
                .description("desc")
                .quantite(15)
                .point_geo("0, 0")
                .build();
        TerrainEntity terrainEntity = terrainMapper.toEntity(terrainDTO);

        assertEquals(42, terrainEntity.getId());
    }
}