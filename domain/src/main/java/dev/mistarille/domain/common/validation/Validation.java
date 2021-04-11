package dev.mistarille.domain.common.validation;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.function.Function;

@AllArgsConstructor
public class Validation<T> {
    private T item = null;
    private final List<IValidator<T>> queue;
    private final Map<IValidator<T>, Function<T, RuntimeException>> exceptions;

    public Validation() {
        this.queue = new ArrayList<>();
        this.exceptions = new HashMap<>();
    }

    public Validation(T item) {
        this();
        this.item = item;
    }

    public static <T> Validation<T> item(T item) {
        return new Validation<>(item);
    }

    public Validation<T> then(IValidator<T> validator) {
        this.queue.add(validator);
        return this;
    }

    public Validation<T> error(Function<T, RuntimeException> function) {
        int queueSize = this.queue.size();

        if (queueSize > 0) {
            this.exceptions.put(this.queue.get(queueSize - 1), function);
        }

        return this;
    }

    public boolean apply() {
        return this.queue
            .stream()
            .allMatch(validator -> {
                boolean validate = validator.validate(item);

                if (!validate) {
                    Function<T, RuntimeException> function = this.exceptions.get(validator);

                    if (Objects.nonNull(function)) {
                        throw function.apply(item);
                    }
                }

                return validate;
            });
    }
}
