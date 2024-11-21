package com.capgemini.polytech.dto;

import lombok.*;

/**
 * Classe DTO (Data Transfer Object) pour représenter une réservation.
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
public class ReservationDTO {

    /**
     * Identifiant de l'utilisateur associé à la réservation.
     */
    private int utilisateur_id;

    /**
     * Identifiant du terrain réservé.
     */
    private int terrain_id;

    /**
     * Nombre de places de la réservation.
     */
    private int reservation;
}
