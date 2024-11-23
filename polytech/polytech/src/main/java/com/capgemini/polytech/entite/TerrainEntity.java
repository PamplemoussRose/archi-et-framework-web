package com.capgemini.polytech.entite;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité JPA représentant un terrain dans la base de données.
 * Cette entité est mappée à la table "TERRAIN" et contient des informations
 * sur un terrain, telles que son nom, sa quantité, sa description et son point géographique.
 */
@Entity(name = "terrain")
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "TERRAIN")
public class TerrainEntity {

    /**
     * Identifiant unique du terrain.
     * Cette valeur est générée automatiquement par la base de données grâce à la stratégie {@link GenerationType#IDENTITY}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nom du terrain.
     */
    @NonNull
    private String nom;

    /**
     * Quantité disponible pour ce terrain.
     */
    @NonNull
    private int quantite;

    /**
     * Description du terrain.
     */
    @NonNull
    private String description;

    /**
     * Point géographique du terrain.
     */
    @NonNull
    private String point_geo;
}
