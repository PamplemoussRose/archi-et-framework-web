package com.capgemini.polytech.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Id
    private int utilisateurId;

    @Id
    private int terrainId;

    @NonNull
    private int reservation;

}
