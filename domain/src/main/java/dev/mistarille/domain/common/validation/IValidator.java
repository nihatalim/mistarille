package dev.mistarille.domain.common.validation;

@FunctionalInterface
public interface IValidator<T> {
    boolean validate(T item);
}
