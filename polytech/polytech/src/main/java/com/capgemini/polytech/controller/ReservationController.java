package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /*
    LES METHODES PRENNENT UN DTO ISSUE DE LA PAGE WEB
    ET APPELENT LES METHODES DU SEVICE POUR TRAITER LES DONNEES
     */

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ReservationDTO> getAllReservation() {
        return reservationService.getAllReservations();
    }

    @GetMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ReservationDTO getReservation(@PathVariable Integer id) {
        return reservationService.getReservation(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ReservationDTO createReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.createReservation(reservationDTO);
    }

    @PutMapping(value = "/{id:\\d+}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ReservationDTO updateReservation(@PathVariable Integer id, @RequestBody ReservationDTO reservationDTO) {
        return reservationService.updateReservation(id, reservationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
    }
}
