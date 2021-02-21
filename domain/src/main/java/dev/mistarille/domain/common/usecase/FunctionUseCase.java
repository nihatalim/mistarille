package dev.mistarille.domain.common.usecase;

import java.util.function.Function;

public abstract class FunctionUseCase<T, R> implements Function<T, R> {
    @Override
    public R apply(T t) {
        validate(t);
        return run(t);
    }

    protected abstract R run(T t);

    protected abstract void validate(T t);
}
