package com.gecharita.anemic.model.vo;

import lombok.*;
import lombok.experimental.Tolerate;


@Builder
@Data
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Age {

    @Setter(AccessLevel.PRIVATE)
    private int value;

    @Tolerate
    protected Age(){}

    private Age(int value){
        if (value < 0){
           throw new ArithmeticException("Age cannot be negative: " + value);
        }
        this.value = value;
    }

    public boolean isAdult(){
        return value >17;
    }
}
