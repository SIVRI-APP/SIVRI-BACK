package edu.unicauca.SivriBackendApp.common.exception.handler;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.exception.CredencialIncorrectaException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


@RestControllerAdvice
public class CustomExceptionHandler{

    private static String ERROR = "bad.generic.request";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Respuesta<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });

        return new ResponseEntity<>(new RespuestaHandler<>(400, ERROR, "", errors).getRespuesta(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CredencialIncorrectaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Respuesta<Map<String, String>>> usuarioSinCredencialesException(final HttpServletRequest req,
                                                                                 final ReglaDeNegocioException ex, final Locale locale) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return new ResponseEntity<>(new RespuestaHandler<>(400, ERROR, "", error).getRespuesta(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReglaDeNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Respuesta<Map<String, String>>> handleGenericException(final HttpServletRequest req,
                                                                                final ReglaDeNegocioException ex, final Locale locale) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return new ResponseEntity<>(new RespuestaHandler<>(400, ERROR, "", error).getRespuesta(), HttpStatus.BAD_REQUEST);
    }
}
