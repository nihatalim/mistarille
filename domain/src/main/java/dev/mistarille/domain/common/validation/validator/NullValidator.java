package dev.mistarille.domain.common.validation.validator;

import dev.mistarille.domain.common.validation.exception.NullValidatorException;
import dev.mistarille.domain.common.validation.IValidator;

import java.lang.reflect.Field;
import java.util.Objects;

public class NullValidator<T> implements IValidator<T> {
    @Override
    public boolean validate(T item) {
        if (Objects.isNull(item)) {
            throw new NullPointerException();
        }

        Field[] fields = item.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object obj = field.get(item);

                if (Objects.isNull(obj)) {
                    throw new NullValidatorException(item.getClass(), field);
                }
            } catch (IllegalAccessException exception) {
                exception.printStackTrace();
            }
        }

        return true;
    }
}