package com.capgemini.polytech.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReservationDTO {

    private int utilisateurId;

    private int terrainId;

}
