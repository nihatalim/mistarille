package dev.mistarille.domain.common.usecase;

import java.util.function.Consumer;

public abstract class ConsumerUseCase<T> implements Consumer<T> {
    @Override
    public void accept(T t) {
        validate(t);
        run(t);
    }

    protected abstract void run(T t);

    protected abstract void validate(T t);
}
