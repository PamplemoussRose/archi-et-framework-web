package com.capgemini.polytech.entite;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "utilisateur")
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "UTILISATEUR")
public class UtilisateurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String username;

}
