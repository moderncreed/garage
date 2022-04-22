package com.example.garage.model;

import java.sql.Date;

public class Order {

    private int price;
    private Driver driver;
    private City city;
    private Date date;

    public Order(int price, Driver driver, City city, Date date) {
        this.price = price;
        this.driver = driver;
        this.city = city;
        this.date = date;
    }

    public Order() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
