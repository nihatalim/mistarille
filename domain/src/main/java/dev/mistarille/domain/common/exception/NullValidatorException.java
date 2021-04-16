package dev.mistarille.domain.common.exception;

import java.lang.reflect.Field;

public class NullValidatorException extends RuntimeException {
    public NullValidatorException(Class<?> className){
        super("Item is null: " + className.getSimpleName());
    }

    public NullValidatorException(Class<?> className, Field field){
        super(className.getSimpleName() + "'s " + field.getName() + " field is null");
    }
}
