package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.TerrainCreateDT0;
import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.entite.Terrain;

public class TerrainMapperImp implements TerrainMapper {
    @Override
    public TerrainDTO entiteToDto(Terrain terrain) {
        if (terrain == null) {
            return null;
        }
        TerrainDTO dto = new TerrainDTO();
        dto.setNom(terrain.getNom());
        dto.setQuantite(terrain.getQuantite());
        dto.setPoint_geo(terrain.getPoint_geo());
        return dto;
    }

    @Override
    public Terrain dtoToEntite(TerrainDTO terrainDTO) {
        if (terrainDTO == null) {
            return null;
        }
        Terrain terrain = new Terrain();
        terrain.setNom(terrainDTO.getNom());
        terrain.setQuantite(terrainDTO.getQuantite());
        terrain.setPoint_geo(terrainDTO.getPoint_geo());
        return terrain;
    }

    @Override
    public TerrainCreateDT0 entiteToCreateDto(Terrain terrain) {
        if (terrain == null) {
            return null;
        }
        TerrainCreateDT0 dto = new TerrainCreateDT0();
        dto.setNom(terrain.getNom());
        dto.setQuantite(terrain.getQuantite());
        dto.setDescription(terrain.getDescription());
        dto.setPoint_geo(terrain.getPoint_geo());
        return dto;
    }

    @Override
    public Terrain createDtoToEntite(TerrainCreateDT0 terrainCreateDT0) {
        if (terrainCreateDT0 == null) {
            return null;
        }
        Terrain terrain = new Terrain();
        terrain.setNom(terrainCreateDT0.getNom());
        terrain.setQuantite(terrainCreateDT0.getQuantite());
        terrain.setDescription(terrainCreateDT0.getDescription());
        terrain.setPoint_geo(terrainCreateDT0.getPoint_geo());
        return terrain;
    }
}
