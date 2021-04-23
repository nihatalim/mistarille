package dev.mistarille.domain.common.validation;

import dev.mistarille.domain.common.validation.validator.NullValidator;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.function.Function;

@AllArgsConstructor
public class Validation<T> {
    private T item = null;

    private final List<IValidator<T>> queue;

    private final Map<IValidator<T>, Function<T, RuntimeException>> exceptions;

    private Validation() {
        this.queue = new ArrayList<>();
        this.exceptions = new HashMap<>();
    }

    private Validation(T item) {
        this();
        this.item = item;
    }

    public static <T> Validation<T> item(T item) {
        return new Validation<>(item);
    }

    public static <T> Validation<T> itemNullCheck(T item) {
        final NullValidator<T> nullValidator = new NullValidator<>();
        final Validation<T> validator = new Validation<>(item);
        return validator.then(nullValidator);
    }

    public Validation<T> then(IValidator<T> validator) {
        this.queue.add(validator);
        return this;
    }

    public Validation<T> error(Function<T, RuntimeException> function) {
        if (!isQueueEmpty()) {
            this.exceptions.put(getLastItem(), function);
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

    private IValidator<T> getLastItem(){
        return this.queue.get(this.queue.size() - 1);
    }

    private boolean isQueueEmpty(){
        return this.queue.size() == 0;
    }
}
