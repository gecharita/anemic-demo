package com.gecharita.anemic.model;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @Setter(AccessLevel.PRIVATE)
    private int age;

    @Setter(AccessLevel.PRIVATE)
    private Location location;

    @Tolerate
    protected Person(){}

}
