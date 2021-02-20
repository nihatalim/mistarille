package dev.mistarille.domain.common.usecase;

import java.util.function.Function;

public interface UseCase<T, R> extends Function<T,T> {
}
