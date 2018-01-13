package com.chriniko.spring.integration.example.client.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
public class Motorcycle {

    private String make;
    private String model;
    private BigDecimal price;
    private Boolean availableForTestDrive;


    public Motorcycle(String make, String model, BigDecimal price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }
}
