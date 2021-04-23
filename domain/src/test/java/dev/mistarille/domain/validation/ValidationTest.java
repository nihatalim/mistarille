package dev.mistarille.domain.validation;

import dev.mistarille.domain.common.validation.IValidator;
import dev.mistarille.domain.common.validation.Validation;
import dev.mistarille.domain.common.validation.ValidationCombiner;
import dev.mistarille.domain.validation.exception.PersonCannotBeNullException;
import dev.mistarille.domain.validation.exception.PersonNameCannotBeNullException;
import dev.mistarille.domain.validation.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    static class PersonValidator implements IValidator<Person>{
        @Override
        public boolean validate(Person person) {
            return Validation.item(person)
                .then(item -> item.getSurname().trim().length() > 0)
                .error(item -> new PersonNameCannotBeNullException("Person surname cannot be empty!"))
                .apply();
        }
    }

    @Test
    public void asd(){
        Person person = new Person("N.hat", ""); //Person.getRandomPerson();
        Stream<Person> personStream = IntStream.range(0, 10)
                                        .mapToObj(i -> Person.getRandomPerson());

        PersonValidator personValidator = new PersonValidator();
        personValidator.validate(person);

        boolean apply = ValidationCombiner.combine(
            Validation.item(person)
                .then(personValidator),

            Validation.item(person.getSurname())
                .then(item -> item.length() > 0)
                .error(item -> new RuntimeException("asdsad")),

            Validation.item(personStream)
                .then(str -> str.noneMatch(Objects::nonNull))
                .error(str -> new RuntimeException("Stream object non null "))
        )
            .error(() -> new RuntimeException("Combination throwws error "))
            .apply();
    }

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
