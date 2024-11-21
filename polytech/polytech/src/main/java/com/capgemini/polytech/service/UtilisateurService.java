package com.capgemini.polytech.service;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entite.UtilisateurEntity;
import com.capgemini.polytech.exception.UtilisateurNotFoundException;
import com.capgemini.polytech.mapper.UtilisateurMapper;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service de gestion des utilisateurs.
 * Cette classe contient la logique métier associée aux utilisateurs.
 * Elle interagit avec le repository {@link UtilisateurRepository} pour effectuer
 * les opérations CRUD (Create, Read, Update, Delete) sur les entités d'utilisateur.
 *
 * Le service reçoit des DTO (Data Transfer Object) en entrée, qui sont ensuite
 * transformés en entités avant d'interagir avec la base de données. Les entités
 * sont ensuite renvoyées sous forme de DTO.
 *
 * @see UtilisateurRepository
 * @see UtilisateurDTO
 * @see UtilisateurEntity
 */
@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    /**
     * Constructeur de la classe {@link UtilisateurService}.
     * @param utilisateurRepository Le repository pour interagir avec la base de données.
     * @param utilisateurMapper Le mapper pour convertir entre les entités et les DTO.
     */
    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    /**
     * Crée un nouvel utilisateur dans la base de données.
     * Le DTO d'utilisateur reçu est converti en entité, puis sauvegardé dans la base de données.
     * Ensuite, l'entité sauvegardée est renvoyée sous forme de DTO.
     *
     * @param utilisateurDTO Le DTO contenant les informations de l'utilisateur.
     * @return Le DTO de l'utilisateur créé.
     */
    public UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO) {
        UtilisateurEntity entity = utilisateurMapper.toEntity(utilisateurDTO);  // Convertir le DTO en entité.
        entity = utilisateurRepository.save(entity);  // Sauvegarder l'entité dans la base de données.
        return utilisateurMapper.toDTO(entity);  // Convertir l'entité sauvegardée en DTO et le renvoyer.
    }

    /**
     * Récupère tous les utilisateurs de la base de données.
     * Les entités récupérées sont converties en DTO avant d'être renvoyées.
     *
     * @return Une liste de DTO représentant tous les utilisateurs.
     */
    public List<UtilisateurDTO> getAllUtilisateurs() {
        List<UtilisateurEntity> entities = utilisateurRepository.findAll();  // Récupérer toutes les entités d'utilisateur.
        List<UtilisateurDTO> dtos = new ArrayList<>();
        for (UtilisateurEntity entity : entities) {
            dtos.add(utilisateurMapper.toDTO(entity));  // Convertir chaque entité en DTO et l'ajouter à la liste.
        }
        return dtos;  // Retourner la liste de DTO.
    }

    /**
     * Récupère un utilisateur spécifique par son identifiant.
     * Si l'utilisateur n'existe pas, une exception {@link UtilisateurNotFoundException} est levée.
     *
     * @param id L'identifiant de l'utilisateur à récupérer.
     * @return Le DTO de l'utilisateur trouvé.
     * @throws UtilisateurNotFoundException Si l'utilisateur avec l'identifiant donné n'existe pas.
     */
    public UtilisateurDTO getUtilisateur(Integer id) throws UtilisateurNotFoundException {
        UtilisateurEntity entity = utilisateurRepository.findById(id)
                .orElseThrow(UtilisateurNotFoundException::new);  // Récupérer l'entité, ou lever une exception si elle n'existe pas.
        return utilisateurMapper.toDTO(entity);  // Convertir l'entité en DTO et le renvoyer.
    }

    /**
     * Met à jour un utilisateur existant.
     * Si l'utilisateur n'existe pas, une exception {@link UtilisateurNotFoundException} est levée.
     * Le DTO reçu contient les nouvelles informations qui seront appliquées à l'entité.
     *
     * @param id L'identifiant de l'utilisateur à mettre à jour.
     * @param utilisateur Le DTO contenant les nouvelles informations de l'utilisateur.
     * @return Le DTO de l'utilisateur mis à jour.
     * @throws UtilisateurNotFoundException Si l'utilisateur avec l'identifiant donné n'existe pas.
     */
    public UtilisateurDTO updateUtilisateur(Integer id, UtilisateurDTO utilisateur) throws UtilisateurNotFoundException {
        UtilisateurEntity existingEntity = utilisateurRepository.findById(id)
                .orElseThrow(UtilisateurNotFoundException::new);  // Récupérer l'entité existante ou lever une exception.
        existingEntity.setNom(utilisateur.getNom());
        existingEntity.setPrenom(utilisateur.getPrenom());
        existingEntity.setMail(utilisateur.getMail());
        existingEntity.setPassword(utilisateur.getPassword());
        existingEntity.setUsername(utilisateur.getUsername());
        existingEntity = utilisateurRepository.save(existingEntity);  // Sauvegarder l'entité mise à jour.
        return utilisateurMapper.toDTO(existingEntity);  // Convertir l'entité mise à jour en DTO et le renvoyer.
    }

    /**
     * Supprime un utilisateur par son identifiant.
     * Si l'utilisateur n'existe pas, une exception {@link UtilisateurNotFoundException} est levée.
     *
     * @param id L'identifiant de l'utilisateur à supprimer.
     * @throws UtilisateurNotFoundException Si l'utilisateur avec l'identifiant donné n'existe pas.
     */
    public void deleteUtilisateur(Integer id) throws UtilisateurNotFoundException {
        if (!utilisateurRepository.existsById(id)) {
            throw new UtilisateurNotFoundException();  // Vérifier si l'utilisateur existe, sinon lever une exception.
        }
        utilisateurRepository.deleteById(id);  // Supprimer l'utilisateur par son identifiant.
    }
}
