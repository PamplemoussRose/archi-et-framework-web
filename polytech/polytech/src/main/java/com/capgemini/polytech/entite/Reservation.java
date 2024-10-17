package com.capgemini.polytech.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "reservation")
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    private int utilisateurId;

    @Id
    private int terrainId;

    @Column(name = "nom", nullable=false)
    private int reservation;

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public int getTerrainId() {
        return terrainId;
    }

    public void setTerrainId(int terrainId) {
        this.terrainId = terrainId;
    }

    public int getReservation() {
        return reservation;
    }

    public void setReservation(int reservation) {
        this.reservation = reservation;
    }
}
