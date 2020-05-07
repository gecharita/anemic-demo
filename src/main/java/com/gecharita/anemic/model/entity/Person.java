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
@ToString
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Setter(AccessLevel.PRIVATE)
    private String name;

    //TIGHTLY coupled
    @Setter(AccessLevel.PRIVATE)
    private PhoneNumber phone;

    // LOOSELY coupled because the column-mapping is outside Age class
    @Convert(converter = AgeConverter.class)
    @Setter(AccessLevel.PRIVATE)
    private Age age;

    // TIGHTLY coupled because the column-mapping is inside Location class
    @Setter(AccessLevel.PRIVATE)
    private Location location;

    @Tolerate
    protected Person(){}

    public String getTaxNumber(){
        String taxNumber = age.getValue()  + location.getCountry() + id;
        return String.valueOf(taxNumber.hashCode()).replace("-","");
    }

}
