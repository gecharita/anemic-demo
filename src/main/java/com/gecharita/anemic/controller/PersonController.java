package com.gecharita.anemic.controller;

import com.gecharita.anemic.model.Person;
import com.gecharita.anemic.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static final Logger LOGGER = Logger.getLogger(PersonController.class.getName()) ;
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/getAll")
    public List<Person> getAllPersons(){
        LOGGER.info(personService.findAll().toString());
        return personService.findAll();
    }

    @GetMapping("/getFirst")
    public ResponseEntity<Person> getFirst(){
        LOGGER.info(personService.findAll().toString());
        return ResponseEntity.ok(personService.findFirst());
    }
}
