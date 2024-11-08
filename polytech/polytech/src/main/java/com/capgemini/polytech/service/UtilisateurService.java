package com.capgemini.polytech.service;

import com.capgemini.polytech.dto.UtilisateurDTO;
import com.capgemini.polytech.entite.UtilisateurEntity;
import com.capgemini.polytech.mapper.UtilisateurMapper;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    private UtilisateurMapper utilisateurMapper;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    /*
    PRENDS TOUJOURS UN DTO EN PARAMETRE CAR LE CONTROLLEUR VA
    EN CREER UN AVEC LE FORM EN WEB
    LE DTO DOIT ETRE TRANSFORME EN ENTITE POUR FARIE LES ACTIONS DU REPOSITORY
    PUIS RETRANSFORME EN DTO POUR RETOURNER LES INFOS
     */

    public UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO) {
        UtilisateurEntity entity = utilisateurMapper.toEntity(utilisateurDTO);
        entity = utilisateurRepository.save(entity);
        return utilisateurMapper.toDTO(entity);
    }

    public List<UtilisateurDTO> getAllUtilisateurs() {
        List<UtilisateurEntity> entities = utilisateurRepository.findAll();
        List<UtilisateurDTO> dtos = new ArrayList<>();
        for (UtilisateurEntity entity : entities) {
            dtos.add(utilisateurMapper.toDTO(entity));
        }
        return dtos;
    }

    public UtilisateurDTO getUtilisateur(Integer id) {
        UtilisateurEntity entity = utilisateurRepository.findById(id).get();
        return utilisateurMapper.toDTO(entity);
    }

    public UtilisateurDTO updateUtilisateur(Integer id, UtilisateurDTO utilisateur) {
        UtilisateurEntity existingEntity = utilisateurRepository.findById(id).get();
        existingEntity.setNom(utilisateur.getNom());
        existingEntity.setPrenom(utilisateur.getPrenom());
        existingEntity.setEmail(utilisateur.getEmail());
        existingEntity.setPassword(utilisateur.getPassword());
        existingEntity.setUsername(utilisateur.getUsername());
        existingEntity = utilisateurRepository.save(existingEntity);
        return utilisateurMapper.toDTO(existingEntity);
    }

    public void deleteUtilisateur(Integer id) {
        utilisateurRepository.deleteById(id);
    }
}