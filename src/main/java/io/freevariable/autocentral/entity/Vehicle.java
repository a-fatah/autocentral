package io.freevariable.autocentral.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vin;

    private String brand;

    private String model;

    private Integer modelYear;

    private Integer price; // in cents

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Contract contract;
}
