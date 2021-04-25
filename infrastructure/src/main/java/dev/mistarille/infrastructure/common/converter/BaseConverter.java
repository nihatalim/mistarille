package dev.mistarille.infrastructure.common.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseConverter<T, R> {
    public abstract R convert(T collection);

    public List<R> convertList(List<T> collections) {
        return collections.stream()
            .map(this::convert)
            .collect(Collectors.toList());
    }
}
