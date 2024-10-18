package com.capgemini.polytech.entite;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "terrain")
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "TERRAIN")
public class TerrainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String nom;

    @NonNull
    private int quantite;

    @NonNull
    private String description;

    @NonNull
    private String point_geo;

}
