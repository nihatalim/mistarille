package dev.mistarille.domain.common.exception.custom;

public class ModelValidationException extends RuntimeException {
    public ModelValidationException(String message) {
        super(message);
    }
}
