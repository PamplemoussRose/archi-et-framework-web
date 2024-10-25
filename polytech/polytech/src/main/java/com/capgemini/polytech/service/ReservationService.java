package com.capgemini.polytech.service;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entite.ReservationEntity;
import com.capgemini.polytech.mapper.ReservationMapper;
import com.capgemini.polytech.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationMapper reservationMapper;

    /*
    PRENDS TOUJOURS UN DTO EN PARAMETRE CAR LE CONTROLLEUR VA
    EN CREER UN AVEC LE FORM EN WEB
    LE DTO DOIT ETRE TRANSFORME EN ENTITE POUR FARIE LES ACTIONS DU REPOSITORY
    PUIS RETRANSFORME EN DTO POUR RETOURNER LES INFOS
     */

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        ReservationEntity entity = reservationMapper.toEntity(reservationDTO);
        entity = reservationRepository.save(entity);
        return reservationMapper.toDTO(entity);
    }

    public List<ReservationDTO> getAllReservations() {
        List<ReservationEntity> list = reservationRepository.findAll();
        List<ReservationDTO> dtos = new ArrayList<ReservationDTO>();
        for (ReservationEntity reservationEntity : list) {
            dtos.add(reservationMapper.toDTO(reservationEntity));
        }
        return dtos;
    }

    public ReservationDTO getReservation(Integer id) {
        ReservationEntity entity =  reservationRepository.findById(id).get();
        return reservationMapper.toDTO(entity);
    }

    public ReservationDTO updateReservation(ReservationDTO reservationDTO) {
        ReservationEntity entity = reservationMapper.toEntity(reservationDTO);
        entity = reservationRepository.save(entity);
        return reservationMapper.toDTO(entity);
    }

    public void deleteReservation(Integer id) {
        reservationRepository.deleteById(id);
    }

}
