package dev.mistarille.domain.common.exception;

import dev.mistarille.domain.common.exception.custom.ModelValidationException;

public class ExceptionEntryPoint {
    public static void throwPropertyIsEmptyException() {
        throwError(ExceptionKey.PROPERTY_IS_EMPTY);
    }

    public static void throwPropertyIsNullException() {
        throwError(ExceptionKey.PROPERTY_IS_NULL);
    }

    private static void throwError(ExceptionKey exceptionKey) {
        throw new ModelValidationException(exceptionKey.getMessageKey());
    }
}
