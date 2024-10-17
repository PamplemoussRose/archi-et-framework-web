package com.capgemini.polytech.entite;

import jakarta.persistence.*;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoint_geo() {
        return point_geo;
    }

    public void setPoint_geo(String point_geo) {
        this.point_geo = point_geo;
    }
}
