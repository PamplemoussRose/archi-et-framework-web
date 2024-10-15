package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.UtilisateurCreateDTO;
import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entite.Utilisateur;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-15T21:21:00+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Override
    public UtilisateurDTO entiteToDto(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();

        utilisateurDTO.setUsername( utilisateur.getUsername() );

        return utilisateurDTO;
    }

    @Override
    public Utilisateur dtoToEntite(UtilisateurDTO terrainDTO) {
        if ( terrainDTO == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setUsername( terrainDTO.getUsername() );

        return utilisateur;
    }

    @Override
    public UtilisateurCreateDTO entiteToCreateDto(Utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        UtilisateurCreateDTO utilisateurCreateDTO = new UtilisateurCreateDTO();

        utilisateurCreateDTO.setNom( utilisateur.getNom() );
        utilisateurCreateDTO.setPrenom( utilisateur.getPrenom() );
        utilisateurCreateDTO.setEmail( utilisateur.getEmail() );
        utilisateurCreateDTO.setPassword( utilisateur.getPassword() );
        utilisateurCreateDTO.setUsername( utilisateur.getUsername() );

        return utilisateurCreateDTO;
    }

    @Override
    public Utilisateur createDtoToEntite(UtilisateurCreateDTO terrainCreateDT0) {
        if ( terrainCreateDT0 == null ) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setNom( terrainCreateDT0.getNom() );
        utilisateur.setPrenom( terrainCreateDT0.getPrenom() );
        utilisateur.setEmail( terrainCreateDT0.getEmail() );
        utilisateur.setPassword( terrainCreateDT0.getPassword() );
        utilisateur.setUsername( terrainCreateDT0.getUsername() );

        return utilisateur;
    }
}
