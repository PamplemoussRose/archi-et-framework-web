package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.service.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terrain")
public class TerrainController {
    @Autowired
    private TerrainService terrainService;

    /*
    LES METHODES PRENNENT UN DTO ISSUE DE LA PAGE WEB
    ET APPELENT LES METHODES DU SEVICE POUR TRAITER LES DONNEES
     */

    @GetMapping
    public List<TerrainDTO> getAllTerrain() {
        return terrainService.getAllTerrain();
    }

    @GetMapping("/{id}")
    public TerrainDTO getTerrain(@PathVariable Integer id) {
        return terrainService.getTerrain(id);
    }

    @PostMapping
    public TerrainDTO createTerrain(@RequestBody TerrainDTO terrainDTO) {
        return terrainService.createTerrain(terrainDTO);
    }

    @PutMapping("/{id}")
    public TerrainDTO updateTerrain(@PathVariable Integer id, @RequestBody TerrainDTO terrainDTO) {
        return terrainService.updateTerrain(id, terrainDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTerrain(@PathVariable Integer id) {
        terrainService.deleteTerrain(id);
    }
}
