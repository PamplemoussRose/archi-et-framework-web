package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.UtilisateurCreateDTO;
import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entite.Utilisateur;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-17T11:12:27+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Override
    public UtilisateurDTO entiteToDto(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();

        return utilisateurDTO;
    }

    @Override
    public Utilisateur dtoToEntite(UtilisateurDTO terrainDTO) {
        if ( terrainDTO == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        return utilisateur;
    }

    @Override
    public UtilisateurCreateDTO entiteToCreateDto(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurCreateDTO utilisateurCreateDTO = new UtilisateurCreateDTO();

        return utilisateurCreateDTO;
    }

    @Override
    public Utilisateur createDtoToEntite(UtilisateurCreateDTO terrainCreateDT0) {
        if ( terrainCreateDT0 == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        return utilisateur;
    }
}
