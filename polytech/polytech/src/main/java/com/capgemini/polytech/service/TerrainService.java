package com.capgemini.polytech.service;

import com.capgemini.polytech.dto.TerrainDTO;
import com.capgemini.polytech.entite.TerrainEntity;
import com.capgemini.polytech.exception.TerrainNotFoundException;
import com.capgemini.polytech.mapper.TerrainMapper;
import com.capgemini.polytech.repository.TerrainRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service de gestion des terrains.
 * Cette classe contient la logique métier associée aux terrains.
 * Elle interagit avec le repository {@link TerrainRepository} pour effectuer
 * les opérations CRUD (Create, Read, Update, Delete) sur les entités de terrain.
 *
 * Le service reçoit des DTO (Data Transfer Object) en entrée, qui sont ensuite
 * transformés en entités avant d'interagir avec la base de données. Les entités
 * sont ensuite renvoyées sous forme de DTO.
 *
 * @see TerrainRepository
 * @see TerrainDTO
 * @see TerrainEntity
 */
@Service
public class TerrainService {

    private final TerrainRepository terrainRepository;
    private final TerrainMapper terrainMapper;

    /**
     * Constructeur de la classe {@link TerrainService}.
     * @param terrainRepository Le repository pour interagir avec la base de données.
     * @param terrainMapper Le mapper pour convertir entre les entités et les DTO.
     */
    public TerrainService(TerrainRepository terrainRepository, TerrainMapper terrainMapper) {
        this.terrainRepository = terrainRepository;
        this.terrainMapper = terrainMapper;
    }

    /**
     * Crée un nouveau terrain dans la base de données.
     * Le DTO de terrain reçu est converti en entité, puis sauvegardé dans la base de données.
     * Ensuite, l'entité sauvegardée est renvoyée sous forme de DTO.
     *
     * @param terrain Le DTO contenant les informations du terrain.
     * @return Le DTO du terrain créé.
     */
    public TerrainDTO createTerrain(TerrainDTO terrain) {
        TerrainEntity entity = terrainMapper.toEntity(terrain);  // Convertir le DTO en entité.
        entity = terrainRepository.save(entity);  // Sauvegarder l'entité dans la base de données.
        return terrainMapper.toDTO(entity);  // Convertir l'entité sauvegardée en DTO et le renvoyer.
    }

    /**
     * Récupère tous les terrains de la base de données.
     * Les entités récupérées sont converties en DTO avant d'être renvoyées.
     *
     * @return Une liste de DTO représentant tous les terrains.
     */
    public List<TerrainDTO> getAllTerrain() {
        List<TerrainEntity> entities = terrainRepository.findAll();  // Récupérer toutes les entités de terrain.
        List<TerrainDTO> dtos = new ArrayList<>();
        for (TerrainEntity entity : entities) {
            dtos.add(terrainMapper.toDTO(entity));  // Convertir chaque entité en DTO et l'ajouter à la liste.
        }
        return dtos;  // Retourner la liste de DTO.
    }

    /**
     * Récupère un terrain spécifique par son identifiant.
     * Si le terrain n'existe pas, une exception {@link TerrainNotFoundException} est levée.
     *
     * @param id L'identifiant du terrain à récupérer.
     * @return Le DTO du terrain trouvé.
     * @throws TerrainNotFoundException Si le terrain avec l'identifiant donné n'existe pas.
     */
    public TerrainDTO getTerrain(Integer id) throws TerrainNotFoundException {
        TerrainEntity entity = terrainRepository.findById(id)
                .orElseThrow(TerrainNotFoundException::new);  // Récupérer l'entité, ou lever une exception si elle n'existe pas.
        return terrainMapper.toDTO(entity);  // Convertir l'entité en DTO et le renvoyer.
    }

    /**
     * Met à jour un terrain existant.
     * Si le terrain n'existe pas, une exception {@link TerrainNotFoundException} est levée.
     * Le DTO reçu contient les nouvelles informations qui seront appliquées à l'entité.
     *
     * @param id L'identifiant du terrain à mettre à jour.
     * @param terrain Le DTO contenant les nouvelles informations du terrain.
     * @return Le DTO du terrain mis à jour.
     * @throws TerrainNotFoundException Si le terrain avec l'identifiant donné n'existe pas.
     */
    public TerrainDTO updateTerrain(Integer id, TerrainDTO terrain) {
        TerrainEntity existingEntity = terrainRepository.findById(id)
                .orElseThrow(TerrainNotFoundException::new);  // Récupérer l'entité existante ou lever une exception.
        existingEntity.setNom(terrain.getNom());
        existingEntity.setQuantite(terrain.getQuantite());
        existingEntity.setDescription(terrain.getDescription());
        existingEntity.setPoint_geo(terrain.getPoint_geo());
        existingEntity = terrainRepository.save(existingEntity);  // Sauvegarder l'entité mise à jour.
        return terrainMapper.toDTO(existingEntity);  // Convertir l'entité mise à jour en DTO et le renvoyer.
    }

    /**
     * Supprime un terrain par son identifiant.
     * Si le terrain n'existe pas, une exception {@link TerrainNotFoundException} est levée.
     *
     * @param id L'identifiant du terrain à supprimer.
     * @throws TerrainNotFoundException Si le terrain avec l'identifiant donné n'existe pas.
     */
    public void deleteTerrain(Integer id) {
        if (!terrainRepository.existsById(id)) {
            throw new TerrainNotFoundException();  // Vérifier si le terrain existe, sinon lever une exception.
        }
        terrainRepository.deleteById(id);  // Supprimer le terrain par son identifiant.
    }
}
