package com.capgemini.polytech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The character has not been found.")
public class ReservationNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
}
