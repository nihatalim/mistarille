package dev.mistarille.domain.validation.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Person{
    private final String name;
    private final String surname;

    public static Person getRandomPerson(){
        return new Person(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }
}