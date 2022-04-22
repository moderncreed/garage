package com.example.garage.model;




public class Car {

    private Long id;
    private String brand;
    private Fuel fuel;

    public Car() {
    }

    public Car(Long id, String brand, Fuel fuel) {
        this.id = id;
        this.brand = brand;
        this.fuel = fuel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
}
