package com.capgemini.polytech.dto;

import lombok.*;

/**
 * Classe DTO (Data Transfer Object) pour représenter un terrain.
 * Elle contient les informations nécessaires pour effectuer des opérations
 * liées aux réservations entre le client et le serveur.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TerrainDTO {

    /**
     * Nom du terrain.
     */
    private String nom;

    /**
     * Quantité de places disponibles pour ce terrain.
     */
    private int quantite;

    /**
     * Description du terrain.
     */
    private String description;

    /**
     * Point géographique du terrain.
     */
    private String point_geo;
}
