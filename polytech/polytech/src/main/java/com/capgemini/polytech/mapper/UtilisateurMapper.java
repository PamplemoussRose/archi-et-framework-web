package com.capgemini.polytech.mapper;

import com.capgemini.polytech.entite.UtilisateurEntity;
import com.capgemini.polytech.dto.UtilisateurDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UtilisateurMapper {
    UtilisateurDTO toDTO(UtilisateurEntity utilisateurEntity);
    UtilisateurEntity toEntity(UtilisateurDTO terrainDTO);
}
