package com.capgemini.polytech.entite;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "utilisateur")
@Table(name = "UTILISATEUR")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nom", nullable=false)
    private String nom;

    @Column(name = "prenom", nullable=false)
    private String prenom;

    @Column(name = "mail", nullable=false)
    private String email;

    @Column(name = "password", nullable=false)
    private String password;

    @Column(name = "username", nullable=false)
    private String username;

}
