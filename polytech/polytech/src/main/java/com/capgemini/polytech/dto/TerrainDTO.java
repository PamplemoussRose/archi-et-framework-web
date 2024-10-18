package com.capgemini.polytech.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TerrainDTO {

    private String nom;

    private int quantite;

    private String description;

    private String point_geo;

}
