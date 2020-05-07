package com.gecharita.anemic.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@Builder
@Data
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PhoneNumber {

    @Column(name="phone")
    @Setter(AccessLevel.PRIVATE)
    private int value;

    @Tolerate
    protected PhoneNumber(){}

    private PhoneNumber(int value){
        if (value >= 1000000){
           throw new ArithmeticException("Phone number must be from 0 to 999999: " + value);
        }
        this.value = value;
    }
}
