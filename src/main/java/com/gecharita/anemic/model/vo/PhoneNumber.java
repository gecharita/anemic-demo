package com.gecharita.anemic.model.vo;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "person")
public class PhoneNumber {

    @Column(name="phone")
    @Setter(AccessLevel.PRIVATE)
    private int value;

    @Tolerate
    protected PhoneNumber(){}
}
