package com.gecharita.anemic.model;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Builder
@ToString
//@Value
//@NoArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PROTECTED) //Hides the constructor to force useage of the Builder.
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int phone;
    private String address;
    private String country;
    private int age;

    @Tolerate
    protected Person(){}

}
