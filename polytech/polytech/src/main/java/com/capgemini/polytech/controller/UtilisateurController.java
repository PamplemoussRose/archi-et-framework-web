package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.service.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    /*
    LES METHODES PRENNENT UN DTO ISSUE DE LA PAGE WEB
    ET APPELENT LES METHODES DU SEVICE POUR TRAITER LES DONNEES
     */

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UtilisateurDTO> getAllUtilisateur() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UtilisateurDTO getUtilisateur(@PathVariable Integer id) {
        return utilisateurService.getUtilisateur(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public UtilisateurDTO createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.createUtilisateur(utilisateurDTO);
    }

    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public UtilisateurDTO updateUtilisateur(@PathVariable Integer id, @RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.updateUtilisateur(id, utilisateurDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.deleteUtilisateur(id);
    }

}
