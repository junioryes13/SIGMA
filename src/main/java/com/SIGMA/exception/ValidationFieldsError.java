package com.SIGMA.exception;

import java.time.LocalDateTime;

public class ValidationFieldsError extends Erros {

    private String field;
    private String fieldsMessage;

    public ValidationFieldsError(LocalDateTime timeError, Integer statusCode, String status, String details, String field, String fieldsMessage) {
        super(timeError, statusCode, status, details);
        this.field = field;
        this.fieldsMessage = fieldsMessage;
    }

    public String getField() {
        return field;
    }

    public String getFieldsMessage() {
        return fieldsMessage;
    }
}
