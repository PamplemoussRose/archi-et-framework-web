package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.UtilisateurCreateDTO;
import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entite.Utilisateur;

public class UtilisateurMapperImp implements UtilisateurMapper {
    @Override
    public UtilisateurDTO entiteToDto(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setUsername(utilisateur.getUsername());
        return dto;
    }

    @Override
    public Utilisateur dtoToEntite(UtilisateurDTO terrainDTO) {
        if (terrainDTO == null) {
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(terrainDTO.getUsername());
        return utilisateur;
    }

    @Override
    public UtilisateurCreateDTO entiteToCreateDto(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }
        UtilisateurCreateDTO dto = new UtilisateurCreateDTO();
        dto.setNom(utilisateur.getNom());
        dto.setPrenom(utilisateur.getPrenom());
        dto.setEmail(utilisateur.getEmail());
        dto.setUsername(utilisateur.getUsername());
        dto.setPassword(utilisateur.getPassword());
        return dto;
    }

    @Override
    public Utilisateur createDtoToEntite(UtilisateurCreateDTO terrainCreateDT0) {
        if (terrainCreateDT0 == null) {
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(terrainCreateDT0.getNom());
        utilisateur.setPrenom(terrainCreateDT0.getPrenom());
        utilisateur.setEmail(terrainCreateDT0.getEmail());
        utilisateur.setUsername(terrainCreateDT0.getUsername());
        utilisateur.setPassword(terrainCreateDT0.getPassword());
        return utilisateur;
    }
}
