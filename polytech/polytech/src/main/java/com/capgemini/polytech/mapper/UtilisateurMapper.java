package com.capgemini.polytech.mapper;

import com.capgemini.polytech.entite.Utilisateur;
import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.dto.UtilisateurCreateDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UtilisateurMapper {
    public UtilisateurDTO entiteToDto(Utilisateur utilisateur);
    public Utilisateur dtoToEntite(UtilisateurDTO terrainDTO);

    public UtilisateurCreateDTO entiteToCreateDto(Utilisateur utilisateur);
    public Utilisateur createDtoToEntite(UtilisateurCreateDTO terrainCreateDT0);
}
