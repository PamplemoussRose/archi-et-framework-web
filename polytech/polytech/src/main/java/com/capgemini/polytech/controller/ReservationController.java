package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.exception.ReservationNotFoundException;
import com.capgemini.polytech.exception.UtilisateurNotFoundException;
import com.capgemini.polytech.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les réservations.
 * Ce contrôleur expose des endpoints permettant d'effectuer des opérations CRUD (Create, Read, Update, Delete)
 * sur les réservations. Il délègue les opérations métier à la classe {@link ReservationService}.
 *
 * @see ReservationService
 * @see ReservationDTO
 */
@Slf4j
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    /**
     * Constructeur pour initialiser le service des réservations.
     * Le service est utilisé pour effectuer les opérations liées aux réservations.
     *
     * @param reservationService Instance du service utilisé pour gérer les réservations.
     */
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Récupère toutes les réservations existantes.
     * Cette méthode appelle le service {@link ReservationService#getAllReservations()}
     * pour récupérer toutes les réservations et les retourner sous forme de liste de DTO.
     *
     * @return Une liste d'objets {@link ReservationDTO} représentant toutes les réservations.
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ReservationDTO> getAllReservation() {
        return reservationService.getAllReservations();
    }

    /**
     * Récupère une réservation spécifique en utilisant l'identifiant de l'utilisateur et du terrain.
     * Cette méthode utilise les identifiants dans l'URL pour créer un {@link ReservationDTO}
     * et appelle le service {@link ReservationService#getReservation(ReservationDTO)} pour récupérer la réservation.
     *
     * @param idU Identifiant de l'utilisateur de la réservation.
     * @param idT Identifiant du terrain associé à la réservation.
     * @return Un objet {@link ReservationDTO} représentant la réservation correspondante.
     * @throws ReservationNotFoundException Si la réservation n'est pas trouvée.
     * @throws UtilisateurNotFoundException Si l'utilisateur associé à la réservation n'existe pas.
     */
    @GetMapping(value = "/{idU:\\d+}/{idT:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ReservationDTO getReservation(@PathVariable Integer idU, @PathVariable Integer idT) {
        ReservationDTO reservationDTO = new ReservationDTO(idU, idT, 0);
        return reservationService.getReservation(reservationDTO);
    }

    /**
     * Crée une nouvelle réservation.
     * Cette méthode reçoit un DTO de réservation, puis appelle le service
     * {@link ReservationService#createReservation(ReservationDTO)} pour créer la réservation dans la base de données.
     *
     * @param reservationDTO Données de la réservation à créer.
     * @return Un objet {@link ReservationDTO} représentant la réservation créée.
     */
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ReservationDTO createReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.createReservation(reservationDTO);
    }

    /**
     * Met à jour une réservation existante.
     * Cette méthode reçoit un DTO de réservation contenant les nouvelles informations, puis appelle le service
     * {@link ReservationService#updateReservation(ReservationDTO)} pour effectuer la mise à jour.
     *
     * @param reservationDTO Données mises à jour de la réservation.
     * @return Un objet {@link ReservationDTO} représentant la réservation mise à jour.
     * @throws ReservationNotFoundException Si la réservation à mettre à jour n'existe pas.
     * @throws UtilisateurNotFoundException Si l'utilisateur associé à la réservation n'existe pas.
     */
    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ReservationDTO updateReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.updateReservation(reservationDTO);
    }

    /**
     * Supprime une réservation spécifique en utilisant l'identifiant de l'utilisateur et du terrain.
     * Cette méthode appelle le service {@link ReservationService#deleteReservation(ReservationDTO)}
     * pour supprimer la réservation correspondante dans la base de données.
     *
     * @param idU Identifiant de l'utilisateur de la réservation à supprimer.
     * @param idT Identifiant du terrain associé à la réservation à supprimer.
     * @throws ReservationNotFoundException Si la réservation à supprimer n'existe pas.
     * @throws UtilisateurNotFoundException Si l'utilisateur associé à la réservation n'existe pas.
     */
    @DeleteMapping("/{idU:\\d+}/{idT:\\d+}")
    public void deleteReservation(@PathVariable Integer idU, @PathVariable Integer idT) {
        ReservationDTO reservationDTO = new ReservationDTO(idU, idT, 0);
        reservationService.deleteReservation(reservationDTO);
    }
}
