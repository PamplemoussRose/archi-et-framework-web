package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.TerrainCreateDT0;
import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.entite.Terrain;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-15T21:21:00+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class TerrainMapperImpl implements TerrainMapper {

    @Override
    public TerrainDTO entiteToDto(Terrain terrain) {
        if ( terrain == null ) {
            return null;
        }

        TerrainDTO terrainDTO = new TerrainDTO();

        terrainDTO.setNom( terrain.getNom() );
        terrainDTO.setQuantite( terrain.getQuantite() );
        terrainDTO.setPoint_geo( terrain.getPoint_geo() );

        return terrainDTO;
    }

    @Override
    public Terrain dtoToEntite(TerrainDTO terrainDTO) {
        if ( terrainDTO == null ) {
            return null;
        }

        Terrain terrain = new Terrain();

        terrain.setNom( terrainDTO.getNom() );
        terrain.setQuantite( terrainDTO.getQuantite() );
        terrain.setPoint_geo( terrainDTO.getPoint_geo() );

        return terrain;
    }

    @Override
    public TerrainCreateDT0 entiteToCreateDto(Terrain terrain) {
        if ( terrain == null ) {
            return null;
        }

        TerrainCreateDT0 terrainCreateDT0 = new TerrainCreateDT0();

        terrainCreateDT0.setNom( terrain.getNom() );
        terrainCreateDT0.setQuantite( terrain.getQuantite() );
        terrainCreateDT0.setDescription( terrain.getDescription() );
        terrainCreateDT0.setPoint_geo( terrain.getPoint_geo() );

        return terrainCreateDT0;
    }

    @Override
    public Terrain createDtoToEntite(TerrainCreateDT0 terrainCreateDT0) {
        if ( terrainCreateDT0 == null ) {
            return null;
        }

        Terrain terrain = new Terrain();

        terrain.setNom( terrainCreateDT0.getNom() );
        terrain.setQuantite( terrainCreateDT0.getQuantite() );
        terrain.setDescription( terrainCreateDT0.getDescription() );
        terrain.setPoint_geo( terrainCreateDT0.getPoint_geo() );

        return terrain;
    }
}
