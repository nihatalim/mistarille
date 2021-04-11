package dev.mistarille.domain.validation;

import dev.mistarille.domain.common.validation.Validation;
import dev.mistarille.domain.common.validation.ValidationCombiner;
import dev.mistarille.domain.validation.exception.PersonCannotBeNullException;
import dev.mistarille.domain.validation.exception.PersonNameCannotBeNullException;
import dev.mistarille.domain.validation.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    @Test
    public void validation_combiner_result_true_for_random_person() {
        boolean validationResult = validateRandomPerson();
        assertTrue(validationResult);
    }

    @Test
    public void validation_combiner_result_false_for_random_person() {
        Person person = Person.getRandomPerson();

        boolean validationResult = ValidationCombiner.combine(
            Validation.item(person)
                .then(Objects::isNull)
                .then(item -> Objects.nonNull(item.getName()))
                .error(item -> new PersonNameCannotBeNullException("Person's name cannot be null!"))
        ).apply();

        assertFalse(validationResult);
    }

    @Test
    public void validation_combiner_should_be_throw_person_cannot_be_null_exception() {
        assertThrows(PersonCannotBeNullException.class, this::validateNullPerson);
    }

    @Test
    public void validation_combiner_should_be_throw_person_name_cannot_be_null_exception() {
        assertThrows(PersonNameCannotBeNullException.class, this::validateNullPersonName);
    }

    private boolean validateRandomPerson() {
        final Person person = Person.getRandomPerson();

        return ValidationCombiner.combine(
            Validation.item(person)
                .then(Objects::nonNull)
                .error(item -> new PersonCannotBeNullException("Person cannot be null!"))
                .then(item -> Objects.nonNull(item.getName()))
                .error(item -> new PersonNameCannotBeNullException("Person's name cannot be null!"))
        ).apply();
    }

    private boolean validateNullPerson() {
        final Person person = null;

        return ValidationCombiner.combine(
            Validation.item(person)
                .then(Objects::nonNull)
                .error(item -> new PersonCannotBeNullException("Person cannot be null!"))
                .then(item -> Objects.nonNull(item.getName()))
                .error(item -> new PersonNameCannotBeNullException("Person's name cannot be null!"))
        ).apply();
    }

    private boolean validateNullPersonName() {
        final Person person = new Person(null, "surname");

        return ValidationCombiner.combine(
            Validation.item(person)
                .then(Objects::nonNull)
                .error(item -> new PersonCannotBeNullException("Person cannot be null!"))
                .then(item -> Objects.nonNull(item.getName()))
                .error(item -> new PersonNameCannotBeNullException("Person's name cannot be null!"))
        ).apply();
    }

}
