package com.gecharita.anemic.model;

import com.gecharita.anemic.model.converter.AgeConverter;
import com.gecharita.anemic.model.vo.Age;
import com.gecharita.anemic.model.vo.PhoneNumber;
import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String country;

    @Convert(converter = AgeConverter.class)
    private Age age;
    private PhoneNumber phone;

    @Tolerate
    protected Person(){}

    public String getTaxNumber() {
        int taxNumber = this.hashCode() + (int) Math.tan(id.doubleValue()) + 14;
        return String.valueOf(Math.abs(taxNumber));
    }
}
