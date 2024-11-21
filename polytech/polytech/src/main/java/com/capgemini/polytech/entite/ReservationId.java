package com.capgemini.polytech.entite;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

/**
 * Classe représentant l'identifiant composite pour une réservation.
 * Cette classe est utilisée comme clé primaire pour l'entité {@link ReservationEntity}.
 * Elle est composée de deux attributs : l'identifiant de l'utilisateur et l'identifiant du terrain.
 * La classe implémente {@link Serializable} pour permettre la sérialisation de l'identifiant.
 *
 * L'annotation {@link Embeddable} indique que cette classe peut être intégrée dans une autre entité
 * comme un composant de clé primaire.
 */
@Embeddable
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationId implements Serializable {

    /**
     * Identifiant de l'utilisateur associé à la réservation.
     * Utilisé comme une partie de la clé composite dans la table de réservation.
     */
    private int utilisateurId;

    /**
     * Identifiant du terrain réservé.
     * Utilisé comme une partie de la clé composite dans la table de réservation.
     */
    private int terrainId;
}
