package com.capgemini.polytech.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "reservation")
@Table(name = "RESERVATION")
@Getter
@Setter
public class Reservation {
    @Id
    private int utilisateurId;

    @Id
    private int terrainId;

    @Column(name = "nom", nullable=false)
    private int reservation;
}
