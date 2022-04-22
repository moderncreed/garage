package com.example.garage.model;

public class Driver {

    private Long id;
    private String name;
    private int age;
    private int exp;
    private Car car;

    public Driver() {
    }

    public Driver(Long id, String name, int age, int exp, Car car) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.exp = exp;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
