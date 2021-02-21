package dev.mistarille.domain.common.validation;

import dev.mistarille.domain.common.exception.ExceptionEntryPoint;

import java.util.Objects;
import java.util.function.Predicate;

public class Validation {
    protected void checkValueIsNotEmpty(String value) {
        checkValueIsNotNull(value);

        if (isEmpty.test(value)) {
            ExceptionEntryPoint.throwPropertyIsEmptyException();
        }
    }

    protected void checkValueIsNotNull(String value) {
        if (Objects.isNull(value)) {
            ExceptionEntryPoint.throwPropertyIsNullException();
        }
    }

    protected Predicate<String> isEmpty = (value) -> value.trim().equals("");

    public void elseThrow(RuntimeException e) throws RuntimeException {
        throw e;
    }
}
