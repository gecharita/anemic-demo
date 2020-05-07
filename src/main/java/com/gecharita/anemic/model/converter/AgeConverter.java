package com.gecharita.anemic.model.converter;

import com.gecharita.anemic.model.vo.Age;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AgeConverter implements AttributeConverter<Age, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Age age) {
        return age == null ? 0: age.getValue();
    }

    @Override
    public Age convertToEntityAttribute(Integer integer) {
        int value = (integer == null)? 0: integer;
        return Age.builder().value(value).build();
    }
}
