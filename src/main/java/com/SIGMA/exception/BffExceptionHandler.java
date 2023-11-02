package com.SIGMA.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class BffExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    private final Logger logger = LoggerFactory.getLogger(BffExceptionHandler.class);

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Erros> handleResponseStatusException(ResponseStatusException ex) {
        logger.warn("Mensagem: " + ex.getMessage() + "\nCausa: " + ex.getReason());
        return ResponseEntity.status(ex.getStatus())
                .body(new Erros(LocalDateTime.now(), ex.getStatus().value(), ex.getStatus().toString(), ex.getReason()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Erros> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        logger.warn("Mensagem: " + ex.getMessage());
        return ResponseEntity.badRequest().body(new Erros(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.toString(), ex.getClass().toString()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ValidationFieldsError> handleMethodArgumentNotValidException(MethodArgumentNotValidException
                                                                                     exception) {
        List<ValidationFieldsError> listValidationFieldsError = new ArrayList<>();

        List<FieldError> listFieldErrors = exception.getBindingResult().getFieldErrors();

        listFieldErrors.forEach(fieldError -> {
            String messageContext = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

            ValidationFieldsError validationFieldsError = new ValidationFieldsError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.toString(),
                    exception.getClass().toString(), fieldError.getField(), messageContext);

            listValidationFieldsError.add(validationFieldsError);
        });
        return listValidationFieldsError;
    }

   /* @ExceptionHandler(RetryableException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public Erros handleRetryableException(RetryableException ex) {
        logger.error("Mensagem: " + ex.getMessage() + "\nClasse:" + ex.getClass());
        return new Erros(LocalDateTime.now(), HttpStatus.SERVICE_UNAVAILABLE.value(),
                HttpStatus.SERVICE_UNAVAILABLE.toString(), "Por favor tente novamente mais tarde.");
    }


    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Erros> bad_credentials(AuthenticationException ex) {
        logger.warn(ex.getMessage());
        return ResponseEntity.badRequest().body(new Erros(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.toString(), "revise suas credenciais"));
    }
*/

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Erros> handleConstraintViolationException(ConstraintViolationException ex) {
        logger.warn("Mensagem: " + ex.getMessage());
        return ResponseEntity.badRequest().body(new Erros(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.toString(), ex.getClass().toString()));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Erros> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
        logger.warn("Mensagem: " + ex.getMessage());
        return ResponseEntity.badRequest().body(new Erros(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.toString(), ex.getClass().toString()));
    }

    @ExceptionHandler({Exception.class, NullPointerException.class})
    public ResponseEntity<Erros> handleException(Exception ex) {
        logger.error("Mensagem: " + ex.getMessage() + "\nCausa:" + ex.getCause());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Erros(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage()));
    }

}
