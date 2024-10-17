package com.capgemini.polytech.entite;

import jakarta.persistence.*;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
