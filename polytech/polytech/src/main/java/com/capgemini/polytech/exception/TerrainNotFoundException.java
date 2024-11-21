package com.capgemini.polytech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * Exception levée lorsque le terrain demandé n'a pas été trouvé.
 * Cette exception est utilisée pour indiquer qu'une tentative d'accès à un terrain
 * n'a pas abouti, souvent parce que le terrain n'existe pas dans la base de données.
 * Elle est annotée avec {@link ResponseStatus} pour retourner une réponse HTTP 404 (NOT_FOUND)
 * avec un message personnalisé.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Ce terrain n'existe pas.")
public class TerrainNotFoundException extends RuntimeException {

    /**
     * Identifiant unique de la version de la classe pour la sérialisation.
     */
    @Serial
    private static final long serialVersionUID = 1L;
}
