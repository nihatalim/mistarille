package dev.mistarille.domain.validation.exception;

public class PersonCannotBeNullException extends RuntimeException{
    public PersonCannotBeNullException(String message) {
        super(message);
    }
}
