package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    /*
    LES METHODES PRENNENT UN DTO ISSUE DE LA PAGE WEB
    ET APPELENT LES METHODES DU SEVICE POUR TRAITER LES DONNEES
     */

    @GetMapping
    public List<UtilisateurDTO> getAllUtilisateur() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    public UtilisateurDTO getUtilisateur(@PathVariable Integer id) {
        return utilisateurService.getUtilisateur(id);
    }

    @PostMapping
    public UtilisateurDTO createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.createUtilisateur(utilisateurDTO);
    }

    @PutMapping("/{id}")
    public UtilisateurDTO updateUtilisateur(@PathVariable Integer id, @RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.updateUtilisateur(id, utilisateurDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.deleteUtilisateur(id);
    }

}
