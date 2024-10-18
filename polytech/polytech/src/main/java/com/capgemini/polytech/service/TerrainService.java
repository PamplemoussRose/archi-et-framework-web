package com.capgemini.polytech.service;

import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.entite.TerrainEntity;
import com.capgemini.polytech.mapper.TerrainMapper;
import com.capgemini.polytech.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerrainService {
    @Autowired
    private TerrainRepository terrainRepository;
    @Autowired
    private TerrainMapper terrainMapper;

    /*
    PRENDS TOUJOURS UN DTO EN PARAMETRE CAR LE CONTROLLEUR VA
    EN CREER UN AVEC LE FORM EN WEB
     */

    public TerrainDTO createTerrain(TerrainDTO terrain) {
        // Prends un DTO, transform en entité pour creer l'utilisateur et renvoie un DTO pour
        // recuperer les infos de l'utilisateur
        return null;
    }

    public List<TerrainDTO> getAllTerrain() {
        return null;
    }

    public TerrainDTO getTerrain(Integer id) {
        return null;
    }

    public TerrainDTO updateTerrain(TerrainEntity terrain) {
        return null;
    }

    public void deleteTerrain(Integer id) {

    }
}
