package com.capgemini.polytech.mapper;

import com.capgemini.polytech.entite.Terrain;
import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.dto.TerrainCreateDT0;
import org.mapstruct.Mapper;

@Mapper
public interface TerrainMapper {
    public TerrainDTO entiteToDto(Terrain terrain);
    public Terrain dtoToEntite(TerrainDTO terrainDTO);

    public TerrainCreateDT0 entiteToCreateDto(Terrain terrain);
    public Terrain createDtoToEntite(TerrainCreateDT0 terrainCreateDT0);
}
