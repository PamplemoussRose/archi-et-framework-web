package com.capgemini.polytech.entite;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "reservation")
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "RESERVATION")
public class ReservationEntity {
    @EmbeddedId
    private ReservationId reservationId;

    @NonNull
    private int reservation;

}
