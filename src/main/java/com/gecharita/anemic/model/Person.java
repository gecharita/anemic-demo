package com.gecharita.anemic.model;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.io.Serializable;

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

    @Setter(AccessLevel.PRIVATE)
    private int phone;

    // LOOSELY coupled because the column-mapping is outside Age class
    @Convert(converter = AgeConverter.class)
    @Setter(AccessLevel.PRIVATE)
    private Age age;

    // TIGHTLY coupled because the column-mapping is inside Location class
    @Setter(AccessLevel.PRIVATE)
    private Location location;

    @Tolerate
    protected Person(){}

}
