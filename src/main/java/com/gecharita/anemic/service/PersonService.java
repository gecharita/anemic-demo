package com.gecharita.anemic.service;

import com.gecharita.anemic.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person findFirst();

    Person save(Person person);

    String getTaxNumber(long personId);

    boolean isAdult(long personId);

}
