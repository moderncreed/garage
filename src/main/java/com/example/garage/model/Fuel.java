package com.example.garage.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Fuel {

    private Long id;

    @Size(min = 5,max = 15, message = "Название должно быть 5-15 символов")
    private String brand;

    @Min(value = 80)
    @Max(value = 100, message = "Октановое число должно быть 80-100")
    private int octane;

    public Fuel() {
    }

    public Fuel(Long id, String brand, int octane) {
        this.id = id;
        this.brand = brand;
        this.octane = octane;
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

    public int getOctane() {
        return octane;
    }

    public void setOctane(int octane) {
        this.octane = octane;
    }
}
