package com.capgemini.polytech.dto;

public class TerrainDTO {

    private String nom;

    private int quantite;

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

    public String getPoint_geo() {
        return point_geo;
    }

    public void setPoint_geo(String point_geo) {
        this.point_geo = point_geo;
    }
}
