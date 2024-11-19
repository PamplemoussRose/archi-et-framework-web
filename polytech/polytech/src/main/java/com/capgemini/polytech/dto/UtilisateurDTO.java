package com.capgemini.polytech.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UtilisateurDTO {

    private String nom;

    private String prenom;

    private String mail;

    private String password;

    private String username;

}
