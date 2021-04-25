package com.gecharita.anemic.model.vo;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Location {

    @Setter(AccessLevel.PRIVATE)
    private String address;

    @Setter(AccessLevel.PRIVATE)
    private String country;

    @Tolerate
    protected Location(){}
}
