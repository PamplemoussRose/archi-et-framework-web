package com.capgemini.polytech.controller;

import com.capgemini.polytech.dto.ReservationDTO;
import com.capgemini.polytech.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    /*
    LES METHODES PRENNENT UN DTO ISSUE DE LA PAGE WEB
    ET APPELENT LES METHODES DU SEVICE POUR TRAITER LES DONNEES
     */

    @GetMapping
    public List<ReservationDTO> getAllReservation() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ReservationDTO getReservation(@PathVariable Integer id) {
        return reservationService.getReservation(id);
    }

    @PostMapping
    public ReservationDTO createReservation(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.createReservation(reservationDTO);
    }

    @PutMapping("/{id}")
    public ReservationDTO updateReservation(@PathVariable Integer id, @RequestBody ReservationDTO reservationDTO) {
        return reservationService.updateReservation(id, reservationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
    }
}
