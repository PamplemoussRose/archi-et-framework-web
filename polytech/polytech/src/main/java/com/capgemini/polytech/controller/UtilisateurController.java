package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.service.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les utilisateurs.
 * Il expose des endpoints pour effectuer des opérations CRUD sur les utilisateurs.
 */
@Slf4j
@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    /**
     * Constructeur pour initialiser le service des utilisateurs.
     *
     * @param utilisateurService Instance du service utilisé pour gérer les utilisateurs.
     */
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    /**
     * Récupère la liste de tous les utilisateurs.
     *
     * @return Une liste d'objets {@link UtilisateurDTO} représentant tous les utilisateurs.
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UtilisateurDTO> getAllUtilisateur() {
        return utilisateurService.getAllUtilisateurs();
    }

    /**
     * Récupère un utilisateur spécifique par son identifiant.
     *
     * @param id Identifiant de l'utilisateur à récupérer.
     * @return Un objet {@link UtilisateurDTO} représentant l'utilisateur correspondant.
     */
    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UtilisateurDTO getUtilisateur(@PathVariable Integer id) {
        return utilisateurService.getUtilisateur(id);
    }

    /**
     * Crée un nouvel utilisateur.
     *
     * @param utilisateurDTO Données de l'utilisateur à créer.
     * @return Un objet {@link UtilisateurDTO} représentant l'utilisateur créé.
     */
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public UtilisateurDTO createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.createUtilisateur(utilisateurDTO);
    }

    /**
     * Met à jour un utilisateur existant.
     *
     * @param id              Identifiant de l'utilisateur à mettre à jour.
     * @param utilisateurDTO  Données mises à jour de l'utilisateur.
     * @return Un objet {@link UtilisateurDTO} représentant l'utilisateur mis à jour.
     */
    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public UtilisateurDTO updateUtilisateur(@PathVariable Integer id, @RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.updateUtilisateur(id, utilisateurDTO);
    }

    /**
     * Supprime un utilisateur spécifique par son identifiant.
     *
     * @param id Identifiant de l'utilisateur à supprimer.
     */
    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.deleteUtilisateur(id);
    }
}
