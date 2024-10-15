package com.capgemini.polytech.entite;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "terrain")
@Table(name = "TERRAIN")
public class Terrain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "quantite", nullable = false)
    private int quantite;

    @Column(name = "description")
    private String description;

    @Column(name = "point_geo", nullable = false)
    private String point_geo;

}
