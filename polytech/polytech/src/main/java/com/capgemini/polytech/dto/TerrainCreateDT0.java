package com.capgemini.polytech.dto;

public class TerrainCreateDT0 {

    private String nom;

    private int quantite;

    private String description;

    private String point_geo;

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
