package com.gecharita.anemic.mapper;

import com.gecharita.anemic.dto.PersonDTO;
import com.gecharita.anemic.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(source = "address", target = "location.address")
    @Mapping(source = "country", target = "location.country")
    @Mapping(source = "age", target = "age.value")
    Person toPerson(PersonDTO personDTO);

    @Mapping(source = "location.address", target = "address")
    @Mapping(source = "location.country", target = "country")
    @Mapping(source = "age.value", target = "age")
    PersonDTO toPersonDTO(Person person);

}
