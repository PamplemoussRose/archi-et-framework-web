package com.capgemini.polytech.mapper;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entite.UtilisateurEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Override
    public UtilisateurDTO toDTO(UtilisateurEntity utilisateurEntity) {
        if ( utilisateurEntity == null ) {
            return null;
        }

        UtilisateurDTO.UtilisateurDTOBuilder utilisateurDTO = UtilisateurDTO.builder();

        utilisateurDTO.nom( utilisateurEntity.getNom() );
        utilisateurDTO.prenom( utilisateurEntity.getPrenom() );
        utilisateurDTO.email( utilisateurEntity.getEmail() );
        utilisateurDTO.password( utilisateurEntity.getPassword() );
        utilisateurDTO.username( utilisateurEntity.getUsername() );

        return utilisateurDTO.build();
    }

    @Override
    public UtilisateurEntity toEntity(UtilisateurDTO terrainDTO) {
        if ( terrainDTO == null ) {
            return null;
        }

        UtilisateurEntity.UtilisateurEntityBuilder utilisateurEntity = UtilisateurEntity.builder();

        utilisateurEntity.nom( terrainDTO.getNom() );
        utilisateurEntity.prenom( terrainDTO.getPrenom() );
        utilisateurEntity.email( terrainDTO.getEmail() );
        utilisateurEntity.password( terrainDTO.getPassword() );
        utilisateurEntity.username( terrainDTO.getUsername() );

        return utilisateurEntity.build();
    }
}
