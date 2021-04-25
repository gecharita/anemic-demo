package com.gecharita.anemic.controller;

import com.gecharita.anemic.dto.PersonDTO;
import com.gecharita.anemic.mapper.PersonMapper;
import com.gecharita.anemic.model.Person;
import com.gecharita.anemic.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static final Logger LOGGER = Logger.getLogger(PersonController.class.getName()) ;
    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper){
        this.personMapper = personMapper;
        this.personService = personService;
    }

    @GetMapping()
    public ResponseEntity<List<PersonDTO>> getAll(){
        List<Person> personList = personService.findAll();
        List<PersonDTO> personDTOList = personList.stream().map(personMapper::toPersonDTO).collect(Collectors.toList());
        return  ResponseEntity.ok(personDTOList);
    }

    @PostMapping("")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO){
        Person person = personMapper.toPerson(personDTO);
        person = personService.save(person);
        return ResponseEntity.ok(personMapper.toPersonDTO(person));
    }

    @GetMapping("/getFirst")
    public ResponseEntity<PersonDTO> getFirst(){
        Person person = personService.findFirst();
        PersonDTO personDTO = personMapper.toPersonDTO(person);
        return ResponseEntity.ok(personDTO);
    }

    @GetMapping("/taxNumber/{personId}")
    public ResponseEntity<String> getTaxNumber(@PathVariable long personId){
        return ResponseEntity.ok(personService.getTaxNumber(personId));
    }

    @GetMapping("/isAdult/{personId}")
    public ResponseEntity<Boolean> isAdult(@PathVariable long personId){
        return ResponseEntity.ok(personService.isAdult(personId));
    }


    private void test() {
        Person person = Person.builder().address("Egnatia").country("Hellas").build();
    }


}
