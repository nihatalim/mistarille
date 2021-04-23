package dev.mistarille.domain.validation.exception;

public class PersonNameCannotBeNullException extends RuntimeException{
    public PersonNameCannotBeNullException(String message) {
        super(message);
    }
}