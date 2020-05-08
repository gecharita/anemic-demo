package com.gecharita.anemic.model.vo;

import lombok.*;
import lombok.experimental.Tolerate;


@Builder
@Data
@Setter(AccessLevel.PRIVATE)
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Age {

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
