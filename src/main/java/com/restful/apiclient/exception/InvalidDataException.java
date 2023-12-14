package com.restful.apiclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando os dados fornecidos são inválidos.
 * <p>
 * Esta exceção é anotada com {@code @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)}, indicando
 * que resultará em uma resposta HTTP 422 (Unprocessable Entity) quando lançada.
 */
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidDataException extends RuntimeException {

    /**
     * Construtor da exceção InvalidDataException.
     *
     * @param message Mensagem de erro que descreve a razão da exceção.
     */
    public InvalidDataException(String message) {
        super(message);
    }
}
