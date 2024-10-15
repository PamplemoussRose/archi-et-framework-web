package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.UtilisateurCreateDTO;
import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entite.Utilisateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurMapperIntegrationTest {

    private UtilisateurMapper utilisateurMapper = new UtilisateurMapperImp();

    @Test
    void entiteToDto() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1);
        utilisateur.setNom("Doe");
        utilisateur.setPrenom("Jhon");
        utilisateur.setEmail("doe@doe.com");
        utilisateur.setUsername("doejhon");
        utilisateur.setPassword("password");

        UtilisateurDTO dto = utilisateurMapper.entiteToDto(utilisateur);

        assertNotNull(dto);
        assertEquals(utilisateur.getUsername(), dto.getUsername());
    }

    @Test
    void dtoToEntite() {
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.setUsername("doejhon");

        Utilisateur utilisateur = utilisateurMapper.dtoToEntite(dto);

        assertNotNull(utilisateur);
        assertEquals(dto.getUsername(), utilisateur.getUsername());
    }

    @Test
    void entiteToCreateDto() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1);
        utilisateur.setNom("Doe");
        utilisateur.setPrenom("Jhon");
        utilisateur.setEmail("doe@doe.com");
        utilisateur.setUsername("doejhon");
        utilisateur.setPassword("password");

        UtilisateurCreateDTO createDTO = utilisateurMapper.entiteToCreateDto(utilisateur);

        assertNotNull(createDTO);
        assertEquals(utilisateur.getNom(), createDTO.getNom());
        assertEquals(utilisateur.getPrenom(), createDTO.getPrenom());
        assertEquals(utilisateur.getEmail(), createDTO.getEmail());
        assertEquals(utilisateur.getUsername(), createDTO.getUsername());
        assertEquals(utilisateur.getPassword(), createDTO.getPassword());
    }

    @Test
    void createDtoToEntite() {
        UtilisateurCreateDTO createDTO = new UtilisateurCreateDTO();
        createDTO.setNom("Doe");
        createDTO.setPrenom("Jhon");
        createDTO.setEmail("doe@doe.com");
        createDTO.setUsername("doejhon");
        createDTO.setPassword("password");

        Utilisateur utilisateur = utilisateurMapper.createDtoToEntite(createDTO);

        assertNotNull(utilisateur);
        assertEquals(createDTO.getNom(), utilisateur.getNom());
        assertEquals(createDTO.getPrenom(), utilisateur.getPrenom());
        assertEquals(createDTO.getEmail(), utilisateur.getEmail());
        assertEquals(createDTO.getUsername(), utilisateur.getUsername());
        assertEquals(createDTO.getPassword(), utilisateur.getPassword());
    }
}