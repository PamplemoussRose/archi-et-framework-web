package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.TerrainCreateDT0;
import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.entite.Terrain;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-17T11:12:27+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class TerrainMapperImpl implements TerrainMapper {

    @Override
    public TerrainDTO entiteToDto(Terrain terrain) {
        if ( terrain == null ) {
            return null;
        }

        TerrainDTO terrainDTO = new TerrainDTO();

        return terrainDTO;
    }

    @Override
    public Terrain dtoToEntite(TerrainDTO terrainDTO) {
        if ( terrainDTO == null ) {
            return null;
        }

        Terrain terrain = new Terrain();

        return terrain;
    }

    @Override
    public TerrainCreateDT0 entiteToCreateDto(Terrain terrain) {
        if ( terrain == null ) {
            return null;
        }

        TerrainCreateDT0 terrainCreateDT0 = new TerrainCreateDT0();

        return terrainCreateDT0;
    }

    @Override
    public Terrain createDtoToEntite(TerrainCreateDT0 terrainCreateDT0) {
        if ( terrainCreateDT0 == null ) {
            return null;
        }

        Terrain terrain = new Terrain();

        return terrain;
    }
}
