package com.capgemini.polytech.dto;

import lombok.*;

/**
 * Classe DTO (Data Transfer Object) pour représenter un utilisateur.
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
public class UtilisateurDTO {

    /**
     * Id de l'utilisateur.
     */
    private int id;

    /**
     * Nom de l'utilisateur.
     */
    private String nom;

    /**
     * Prénom de l'utilisateur.
     */
    private String prenom;

    /**
     * Adresse email de l'utilisateur.
     */
    private String mail;

    /**
     * Mot de passe de l'utilisateur.
     */
    private String password;

    /**
     * Pseudo de l'utilisateur.
     */
    private String username;
}
