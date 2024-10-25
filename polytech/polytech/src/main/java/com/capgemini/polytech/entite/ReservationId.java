package com.capgemini.polytech.entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationId implements Serializable {

    private int utilisateurId;
    private int terrainId;
}
