package com.gecharita.anemic.model.vo;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.Embeddable;

@Builder
@Data
public class Age {

    @Setter(AccessLevel.PRIVATE)
    private int value;

    @Tolerate
    protected Age(){}

    private Age(int age) {
        if (age >= 150) {
            throw new ArithmeticException("Not real age");
        }
        this.value = age;
    }

    public boolean isAdult() {
        return this.value > 17;
    }
}
