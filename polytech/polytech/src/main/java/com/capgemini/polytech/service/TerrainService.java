package com.capgemini.polytech.service;

import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.entite.TerrainEntity;
import com.capgemini.polytech.mapper.TerrainMapper;
import com.capgemini.polytech.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    LE DTO DOIT ETRE TRANSFORME EN ENTITE POUR FARIE LES ACTIONS DU REPOSITORY
    PUIS RETRANSFORME EN DTO POUR RETOURNER LES INFOS
     */

    public TerrainDTO createTerrain(TerrainDTO terrain) {
        // Prends un DTO, transform en entité pour creer l'utilisateur et renvoie un DTO pour
        // recuperer les infos de l'utilisateur
        TerrainEntity entity = terrainMapper.toEntity(terrain);
        entity = terrainRepository.save(entity);
        return terrainMapper.toDTO(entity);
    }

    public List<TerrainDTO> getAllTerrain() {
        List<TerrainEntity> entities = terrainRepository.findAll();
        List<TerrainDTO> dtos = new ArrayList<TerrainDTO>();
        for (TerrainEntity entity : entities) {
            dtos.add(terrainMapper.toDTO(entity));
        }
        return dtos;
    }

    public TerrainDTO getTerrain(Integer id) {
        TerrainEntity entity = terrainRepository.findById(id).get();
        return terrainMapper.toDTO(entity);
    }

    public TerrainDTO updateTerrain(Integer id, TerrainDTO terrain) {
        TerrainEntity existingEntity = terrainRepository.findById(id).get();
        existingEntity.setNom(terrain.getNom());
        existingEntity.setQuantite(terrain.getQuantite());
        existingEntity.setDescription(terrain.getDescription());
        existingEntity.setPoint_geo(terrain.getPoint_geo());
        existingEntity = terrainRepository.save(existingEntity);
        return terrainMapper.toDTO(existingEntity);
    }

    public void deleteTerrain(Integer id) {
        terrainRepository.deleteById(id);
    }
}
