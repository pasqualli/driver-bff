package br.com.tlf.tt.models;

import lombok.Data;

@Data
public class Vehicle {
    private String licencePlate;
    private String brand;
    private String model;
    private int driverId;
}
