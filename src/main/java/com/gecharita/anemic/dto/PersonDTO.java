package com.gecharita.anemic.dto;

import lombok.*;

import java.io.Serializable;

@Data
public class PersonDTO implements Serializable {

    private Long id;
    private String name;
    private int phone;
    private String address;
    private String country;
    private int age;

}
