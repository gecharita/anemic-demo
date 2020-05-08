package com.gecharita.anemic.model.entity;

import com.gecharita.anemic.model.vo.Age;
import com.gecharita.anemic.model.converter.AgeConverter;
import com.gecharita.anemic.model.vo.Location;
import com.gecharita.anemic.model.vo.PhoneNumber;
import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;

@Entity
@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    //TIGHTLY coupled
    private PhoneNumber phone;
    // LOOSELY coupled because the column-mapping is outside Age class
    @Convert(converter = AgeConverter.class)
    private Age age;

    // TIGHTLY coupled because the column-mapping is inside Location class
    private Location location;

    @Tolerate
    protected Person(){}

    public String getTaxNumber(){
        return String.valueOf(Math.abs(hashCode()));
    }

}
