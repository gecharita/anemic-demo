package com.gecharita.anemic.model.vo;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@Data
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Location {

    private String address;
    private String country;

    @Tolerate
    protected Location(){}
}
