package com.gecharita.anemic.mapper;

import com.gecharita.anemic.dto.PersonDTO;
import com.gecharita.anemic.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(source = "phone", target = "phone.value")
    @Mapping(source = "age", target = "age.value")
    Person toPerson(PersonDTO personDTO);

    @Mapping(source = "phone.value", target = "phone")
    @Mapping(source = "age.value", target = "age")
    PersonDTO toPersonDTO(Person person);

}
