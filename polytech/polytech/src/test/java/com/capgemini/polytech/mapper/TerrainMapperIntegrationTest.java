package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.TerrainCreateDT0;
import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.entite.Terrain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TerrainMapperIntegrationTest {

    private TerrainMapper terrainMapper = new TerrainMapperImp();

    @Test
    void entiteToDto() {
        Terrain terrain = new Terrain();
        terrain.setId(1);
        terrain.setNom("premier");
        terrain.setQuantite(52);
        terrain.setDescription("c'est le premier");
        terrain.setPoint_geo("1,1");

        TerrainDTO terrainDTO = terrainMapper.entiteToDto(terrain);

        assertNotNull(terrainDTO);
        assertEquals(terrain.getNom(), terrainDTO.getNom());
        assertEquals(terrain.getQuantite(), terrainDTO.getQuantite());
        assertEquals(terrain.getPoint_geo(), terrainDTO.getPoint_geo());
    }

    @Test
    void dtoToEntite() {
        TerrainDTO terrainDTO = new TerrainDTO();
        terrainDTO.setNom("premier");
        terrainDTO.setQuantite(52);
        terrainDTO.setPoint_geo("1,1");

        Terrain terrain = terrainMapper.dtoToEntite(terrainDTO);

        assertNotNull(terrain);
        assertEquals(terrain.getNom(), terrainDTO.getNom());
        assertEquals(terrain.getQuantite(), terrainDTO.getQuantite());
        assertEquals(terrain.getPoint_geo(), terrainDTO.getPoint_geo());
    }

    @Test
    void entiteToCreateDto() {
        Terrain terrain = new Terrain();
        terrain.setId(1);
        terrain.setNom("premier");
        terrain.setQuantite(52);
        terrain.setDescription("c'est le premier");
        terrain.setPoint_geo("1,1");

        TerrainCreateDT0 terrainCreateDT0 = terrainMapper.entiteToCreateDto(terrain);

        assertNotNull(terrainCreateDT0);
        assertEquals(terrain.getNom(), terrainCreateDT0.getNom());
        assertEquals(terrain.getQuantite(), terrainCreateDT0.getQuantite());
        assertEquals(terrain.getDescription(), terrainCreateDT0.getDescription());
        assertEquals(terrain.getPoint_geo(), terrainCreateDT0.getPoint_geo());
    }

    @Test
    void createDtoToEntite() {
        TerrainCreateDT0 terrainCreateDT0 = new TerrainCreateDT0();
        terrainCreateDT0.setNom("premier");
        terrainCreateDT0.setQuantite(52);
        terrainCreateDT0.setDescription("c'est le premier");
        terrainCreateDT0.setPoint_geo("1,1");

        Terrain terrain = terrainMapper.createDtoToEntite(terrainCreateDT0);

        assertNotNull(terrain);
        assertEquals(terrain.getNom(), terrainCreateDT0.getNom());
        assertEquals(terrain.getQuantite(), terrainCreateDT0.getQuantite());
        assertEquals(terrain.getDescription(), terrainCreateDT0.getDescription());
        assertEquals(terrain.getPoint_geo(), terrainCreateDT0.getPoint_geo());
    }
}