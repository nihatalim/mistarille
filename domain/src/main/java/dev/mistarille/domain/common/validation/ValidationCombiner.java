package dev.mistarille.domain.common.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ValidationCombiner {
    private List<Validation<?>> validations;
    private Supplier<RuntimeException> exception = null;

    public ValidationCombiner(){
        this.validations = new ArrayList<>();
    }

    public ValidationCombiner(Validation<?> ...validation){
        this();
        this.validations.addAll(Arrays.stream(validation).collect(Collectors.toList()));
    }

    public ValidationCombiner add(Validation<?> validation){
        this.validations.add(validation);
        return this;
    }

    public ValidationCombiner error(Supplier<RuntimeException> exception){
        this.exception = exception;
        return this;
    }

    public boolean apply(){
        boolean result = this.validations
            .stream()
            .allMatch(Validation::apply);

        if(!result){
            if(Objects.nonNull(exception)){
                throw exception.get();
            }
        }

        return result;
    }

    public static ValidationCombiner combine(Validation<?> ...validation){
        return new ValidationCombiner(validation);
    }
}
