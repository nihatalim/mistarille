package dev.mistarille.domain.common.usecase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;

public abstract class FunctionUseCase<T, R> implements Function<T, R> {
    protected Logger LOGGER = LogManager.getLogger(getClass());

    @Override
    public R apply(T value) {
        LOGGER.info("Use Case: " + getClass().getSimpleName());

        LOGGER.info("Request Item: " + value.toString());

        validate(value);
        R response = run(value);

        LOGGER.info("Response Item: " + response.toString());

        return response;
    }

    protected abstract R run(T t);

    protected abstract void validate(T t);
}
