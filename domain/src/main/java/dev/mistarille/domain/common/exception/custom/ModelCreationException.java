package dev.mistarille.domain.common.exception.custom;

import dev.mistarille.domain.common.exception.ExceptionKey;

public class ModelCreationException extends RuntimeException {
    public ModelCreationException(ExceptionKey message) {
        super(message.getMessageKey());
    }
}
