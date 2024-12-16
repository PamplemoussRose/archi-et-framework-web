package com.capgemini.polytech.service;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.entite.ReservationEntity;
import com.capgemini.polytech.entite.ReservationId;
import com.capgemini.polytech.exception.ReservationNotFoundException;
import com.capgemini.polytech.exception.UtilisateurNotFoundException;
import com.capgemini.polytech.mapper.ReservationMapper;
import com.capgemini.polytech.repository.ReservationRepository;
import com.capgemini.polytech.repository.TerrainRepository;
import com.capgemini.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service de gestion des réservations.
 * Cette classe contient la logique métier associée aux réservations.
 * Elle interagit avec le repository {@link ReservationRepository} pour effectuer
 * les opérations CRUD (Create, Read, Update, Delete) sur les entités de réservation.
 *
 * Le service reçoit des DTO (Data Transfer Object) en entrée, qui sont ensuite
 * transformés en entités avant d'interagir avec la base de données. Les entités
 * sont ensuite renvoyées sous forme de DTO.
 *
 * @see ReservationRepository
 * @see ReservationDTO
 * @see ReservationEntity
 */
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    /**
     * Constructeur de la classe {@link ReservationService}.
     * @param reservationRepository Le repository pour interagir avec la base de données.
     * @param reservationMapper Le mapper pour convertir entre les entités et les DTO.
     */
    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper, UtilisateurRepository utilisateurRepository, TerrainRepository terrainRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    /**
     * Crée une nouvelle réservation dans la base de données.
     * Le DTO de réservation reçu est converti en entité, puis sauvegardé dans la base de données.
     * Ensuite, l'entité sauvegardée est renvoyée sous forme de DTO.
     *
     * @param reservationDTO Le DTO contenant les informations de la réservation.
     * @return Le DTO de la réservation créée.
     */
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        // Conversion du DTO en entité de réservation
        ReservationEntity entity = reservationMapper.toEntity(reservationDTO);

        // Sauvegarde de l'entité dans la base de données
        entity = reservationRepository.save(entity);

        // Retour du DTO correspondant à l'entité sauvegardée
        return reservationMapper.toDTO(entity);
    }

    /**
     * Récupère toutes les réservations de la base de données.
     * Les entités récupérées sont converties en DTO avant d'être renvoyées.
     *
     * @return Une liste de DTO représentant toutes les réservations.
     */
    public List<ReservationDTO> getAllReservations() {
        // Récupérer toutes les entités de réservation
        List<ReservationEntity> list = reservationRepository.findAll();
        List<ReservationDTO> dtos = new ArrayList<>();

        // Conversion des entités en DTO et ajout à la liste
        for (ReservationEntity reservationEntity : list) {
            dtos.add(reservationMapper.toDTO(reservationEntity));
        }
        return dtos;
    }

    /**
     * Récupère une réservation spécifique par son identifiant composite.
     * Si la réservation n'existe pas, une exception {@link ReservationNotFoundException} est levée.
     * En plus de la réservation, une vérification est effectuée pour s'assurer que l'utilisateur
     * et le terrain associés à la réservation existent.
     *
     * @param reservationDTO Le DTO contenant les informations de la réservation à rechercher.
     * @return Le DTO de la réservation trouvée.
     * @throws ReservationNotFoundException Si la réservation avec les identifiants donnés n'existe pas.
     * @throws UtilisateurNotFoundException Si l'utilisateur associé à la réservation n'existe pas.
     */
    public ReservationDTO getReservation(ReservationDTO reservationDTO) throws ReservationNotFoundException {
        // Création de l'identifiant composite à partir des données du DTO
        ReservationId reservationId = new ReservationId(
                reservationDTO.getIdUtilisateur(),
                reservationDTO.getIdTerrain()
        );

        // Recherche de la réservation avec l'identifiant composite
        ReservationEntity entity = reservationRepository.findById(reservationId)
                .orElseThrow(ReservationNotFoundException::new);  // Si la réservation n'est pas trouvée, une exception est levée.

        // Retour du DTO correspondant à l'entité trouvée
        return reservationMapper.toDTO(entity);
    }

    /**
     * Met à jour une réservation existante.
     * Si la réservation n'existe pas, une exception {@link ReservationNotFoundException} est levée.
     * Le DTO reçu contient les nouvelles informations qui seront appliquées à l'entité.
     *
     * @param reservationDTO Le DTO contenant les nouvelles informations de la réservation.
     * @return Le DTO de la réservation mise à jour.
     * @throws ReservationNotFoundException Si la réservation avec l'identifiant donné n'existe pas.
     * @throws UtilisateurNotFoundException Si l'utilisateur associé à la réservation n'existe pas.
     */
    public ReservationDTO updateReservation(ReservationDTO reservationDTO) throws ReservationNotFoundException {
        // Création de l'identifiant composite à partir des données du DTO
        ReservationId reservationId = new ReservationId(
                reservationDTO.getIdUtilisateur(),
                reservationDTO.getIdTerrain()
        );

        // Recherche de la réservation existante avec l'identifiant composite
        ReservationEntity existingEntity = reservationRepository.findById(reservationId)
                .orElseThrow(ReservationNotFoundException::new);  // Si la réservation n'est pas trouvée, une exception est levée.

        // Mise à jour des données de la réservation (ici, la propriété 'reservation')
        existingEntity.setReservation(reservationDTO.getReservation());

        // Sauvegarde de l'entité mise à jour
        existingEntity = reservationRepository.save(existingEntity);

        // Retour du DTO correspondant à l'entité mise à jour
        return reservationMapper.toDTO(existingEntity);
    }

    /**
     * Supprime une réservation par son identifiant composite.
     * Si la réservation n'existe pas, une exception {@link ReservationNotFoundException} est levée.
     * De plus, une vérification est effectuée pour s'assurer que l'utilisateur associé à la réservation existe.
     *
     * @param reservationDTO Le DTO contenant les informations de la réservation à supprimer.
     * @throws ReservationNotFoundException Si la réservation avec l'identifiant donné n'existe pas.
     * @throws UtilisateurNotFoundException Si l'utilisateur associé à la réservation n'existe pas.
     */
    public void deleteReservation(ReservationDTO reservationDTO) throws ReservationNotFoundException {
        // Création de l'identifiant composite à partir des données du DTO
        ReservationId reservationId = new ReservationId(
                reservationDTO.getIdUtilisateur(),
                reservationDTO.getIdTerrain()
        );

        // Vérification de l'existence de la réservation avant de la supprimer
        if (!reservationRepository.existsById(reservationId)) {
            throw new ReservationNotFoundException();  // Si la réservation n'existe pas, une exception est levée.
        }

        // Suppression de la réservation de la base de données
        reservationRepository.deleteById(reservationId);
    }

}