package dev.mistarille.domain.exception;

public class ModelCreationException extends RuntimeException {
    public ModelCreationException(ExceptionKey message) {
        super(message.getMessageKey());
    }
}
