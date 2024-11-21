package com.capgemini.polytech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * Exception levée lorsque l'utilisateur demandé n'a pas été trouvé.
 * Cette exception est utilisée pour indiquer qu'une tentative d'accès à un utilisateur
 * n'a pas abouti, souvent parce que l'utilisateur n'existe pas dans la base de données.
 * Elle est annotée avec {@link ResponseStatus} pour retourner une réponse HTTP 404 (NOT_FOUND)
 * avec un message personnalisé.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cet utilisateur n'existe pas.")
public class UtilisateurNotFoundException extends RuntimeException {

    /**
     * Identifiant unique de la version de la classe pour la sérialisation.
     */
    @Serial
    private static final long serialVersionUID = 1L;
}
