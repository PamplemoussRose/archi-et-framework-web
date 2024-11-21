package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.service.TerrainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les terrains.
 * Il expose des endpoints pour effectuer des opérations CRUD sur les terrains.
 */
@Slf4j
@RestController
@RequestMapping("/api/terrain")
public class TerrainController {

    private final TerrainService terrainService;

    /**
     * Constructeur pour initialiser le service des terrains.
     *
     * @param terrainService Instance du service utilisé pour gérer les terrains.
     */
    public TerrainController(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    /**
     * Récupère la liste de tous les terrains.
     *
     * @return Une liste d'objets {@link TerrainDTO} représentant tous les terrains.
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TerrainDTO> getAllTerrain() {
        return terrainService.getAllTerrain();
    }

    /**
     * Récupère un terrain spécifique par son identifiant.
     *
     * @param id Identifiant du terrain à récupérer.
     * @return Un objet {@link TerrainDTO} représentant le terrain correspondant.
     */
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public TerrainDTO getTerrain(@PathVariable Integer id) {
        return terrainService.getTerrain(id);
    }

    /**
     * Crée un nouveau terrain.
     *
     * @param terrainDTO Données du terrain à créer.
     * @return Un objet {@link TerrainDTO} représentant le terrain créé.
     */
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TerrainDTO createTerrain(@RequestBody TerrainDTO terrainDTO) {
        return terrainService.createTerrain(terrainDTO);
    }

    /**
     * Met à jour un terrain existant.
     *
     * @param id         Identifiant du terrain à mettre à jour.
     * @param terrainDTO Données mises à jour du terrain.
     * @return Un objet {@link TerrainDTO} représentant le terrain mis à jour.
     */
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TerrainDTO updateTerrain(@PathVariable Integer id, @RequestBody TerrainDTO terrainDTO) {
        return terrainService.updateTerrain(id, terrainDTO);
    }

    /**
     * Supprime un terrain spécifique par son identifiant.
     *
     * @param id Identifiant du terrain à supprimer.
     */
    @DeleteMapping("/{id}")
    public void deleteTerrain(@PathVariable Integer id) {
        terrainService.deleteTerrain(id);
    }
}
