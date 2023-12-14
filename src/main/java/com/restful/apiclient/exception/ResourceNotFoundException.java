package com.restful.apiclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando um recurso não é encontrado.
 * <p>
 * Esta exceção é anotada com {@code @ResponseStatus(HttpStatus.NOT_FOUND)}, indicando
 * que resultará em uma resposta HTTP 404 (Not Found) quando lançada.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Construtor da exceção ResourceNotFoundException.
     *
     * @param message Mensagem de erro que descreve a razão da exceção.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Construtor da exceção ResourceNotFoundException.
     *
     * @param resourceName Nome do recurso não encontrado.
     * @param fieldName    Nome do campo associado ao recurso não encontrado.
     * @param fieldValue   Valor do campo associado ao recurso não encontrado.
     */
    public ResourceNotFoundException(String resourceName,
                                     String fieldName,
                                     Object fieldValue) {

        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
}