package com.capgemini.polytech.entite;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité JPA représentant une réservation dans la base de données.
 * Elle contient des informations liées à la réservation avec une clé composite composée de {@link ReservationId}.
 */
@Entity(name = "reservation")
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "RESERVATION")
public class ReservationEntity {

    /**
     * Identifiant composite de la réservation.
     * Cette clé est composée de plusieurs champs.
     */
    @EmbeddedId
    private ReservationId reservationId;

    /**
     * Nombre de places de la réservation.
     */
    @NonNull
    private int reservation;
}
