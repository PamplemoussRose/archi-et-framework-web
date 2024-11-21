package com.capgemini.polytech.entite;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité JPA représentant un utilisateur dans la base de données.
 * Cette entité est mappée à la table "UTILISATEUR" et contient des informations
 * sur un utilisateur, telles que son nom, prénom, adresse e-mail, mot de passe et pseudo.
 */
@Entity(name = "utilisateur")
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "UTILISATEUR")
public class UtilisateurEntity {

    /**
     * Identifiant unique de l'utilisateur.
     * Cette valeur est générée automatiquement par la base de données grâce à la stratégie {@link GenerationType#IDENTITY}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nom de l'utilisateur.
     */
    @NonNull
    private String nom;

    /**
     * Prénom de l'utilisateur.
     */
    @NonNull
    private String prenom;

    /**
     * Adresse e-mail de l'utilisateur.
     */
    @NonNull
    private String mail;

    /**
     * Mot de passe de l'utilisateur.
     */
    @NonNull
    private String password;

    /**
     * Pseudo de l'utilisateur.
     */
    @NonNull
    private String username;
}
