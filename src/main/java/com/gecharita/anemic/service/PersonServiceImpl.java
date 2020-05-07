package com.gecharita.anemic.service;

import com.gecharita.anemic.model.entity.Person;
import com.gecharita.anemic.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    };

    @Override
    public List<Person> findAll() {
        return StreamSupport.stream(personRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Person findFirst() {
        return personRepository.findAll().iterator().next();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public String getTaxNumber(Long id) {
        Optional<Person> opt = personRepository.findById(id);
        return opt.isPresent() ? opt.get().getTaxNumber(): "No valid personId";
    }
}
