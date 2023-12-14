package com.restful.apiclient.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando um CPF já existe.
 * <p>
 * Esta exceção é anotada com {@code @ResponseStatus(HttpStatus.BAD_REQUEST)}, indicando
 * que resultará em uma resposta HTTP 400 (Bad Request) quando lançada.
 */
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfAlreadyExistsException extends RuntimeException {
    
    private final String cpf;

    /**
     * Construtor da exceção CpfAlreadyExistsException.
     *
     * @param cpf CPF que já existe.
     */
    public CpfAlreadyExistsException(String cpf) {
        super(String.format("CPF '%s' já existe.", cpf));
        this.cpf = cpf;
    }
}