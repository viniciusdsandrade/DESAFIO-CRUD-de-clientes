package com.restful.apiclient.handler;

import com.restful.apiclient.exception.CpfAlreadyExistsException;
import com.restful.apiclient.exception.InvalidDataException;
import com.restful.apiclient.exception.ResourceNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável por tratar exceções globais na aplicação e fornecer respostas adequadas.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * Trata a exceção quando um recurso não é encontrado.
     *
     * @param exception  Exceção do tipo ResourceNotFoundException.
     * @param webRequest Objeto WebRequest contendo informações da requisição.
     * @return ResponseEntity contendo detalhes do erro e status HTTP 404 (Not Found).
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleException(@NotNull ResourceNotFoundException exception,
                                                        @NotNull WebRequest webRequest) {

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "CLIENT_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Trata a exceção quando os dados fornecidos são inválidos.
     *
     * @param exception  Exceção do tipo InvalidDataException.
     * @param webRequest Objeto WebRequest contendo informações da requisição.
     * @return ResponseEntity contendo detalhes do erro e status HTTP 422 (Unprocessable Entity).
     */
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorDetails> InvalidDataException(@NotNull InvalidDataException exception,
                                                             @NotNull WebRequest webRequest) {

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INVALID_DATA"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     * Trata a exceção quando um CPF já existe.
     *
     * @param exception  Exceção do tipo CpfAlreadyExistsException.
     * @param webRequest Objeto WebRequest contendo informações da requisição.
     * @return ResponseEntity contendo detalhes do erro e status HTTP 422 (UNPROCESSABLE_ENTITY).
     */
    @ExceptionHandler(CpfAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleException(@NotNull CpfAlreadyExistsException exception,
                                                        @NotNull WebRequest webRequest) {

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "CPF_ALREADY_EXISTS"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
    }


    /**
     * Trata exceções globais não especificadas.
     *
     * @param exception  Exceção do tipo Exception.
     * @param webRequest Objeto WebRequest contendo informações da requisição.
     * @return ResponseEntity contendo detalhes do erro e status HTTP 500 (Internal Server Error).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(@NotNull Exception exception,
                                                              @NotNull WebRequest webRequest) {

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL_SERVER_ERROR"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Sobrescreve o método padrão para lidar com exceções de argumentos de método não válidos.
     *
     * @param ex      Exceção do tipo MethodArgumentNotValidException.
     * @param headers Cabeçalhos HTTP da resposta.
     * @param status  Código de status HTTP.
     * @param request Objeto WebRequest contendo informações da requisição.
     * @return ResponseEntity contendo detalhes dos erros de validação e status HTTP 422 (UNPROCESSABLE_ENTITY).
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NotNull MethodArgumentNotValidException ex,
                                                                  @NotNull HttpHeaders headers,
                                                                  @NotNull HttpStatusCode status,
                                                                  @NotNull WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();

        errorList.forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}