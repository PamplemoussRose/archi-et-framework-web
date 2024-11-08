package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.service.TerrainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/terrain")
public class TerrainController {

    private TerrainService terrainService;

    public TerrainController(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    /*
    LES METHODES PRENNENT UN DTO ISSUE DE LA PAGE WEB
    ET APPELENT LES METHODES DU SEVICE POUR TRAITER LES DONNEES
     */

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TerrainDTO> getAllTerrain() {
        return terrainService.getAllTerrain();
    }

    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public TerrainDTO getTerrain(@PathVariable Integer id) {
        return terrainService.getTerrain(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TerrainDTO createTerrain(@RequestBody TerrainDTO terrainDTO) {
        return terrainService.createTerrain(terrainDTO);
    }

    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TerrainDTO updateTerrain(@PathVariable Integer id, @RequestBody TerrainDTO terrainDTO) {
        return terrainService.updateTerrain(id, terrainDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTerrain(@PathVariable Integer id) {
        terrainService.deleteTerrain(id);
    }
}
