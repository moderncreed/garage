package com.example.garage.model;


import javax.validation.constraints.Pattern;

public class City {

    private Long id;
    @Pattern(regexp = "(([А-Яа-я]{3,25}))", message = "Город должен состоять из 3-25 букв")
    private String name;

    public City() {
    }

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
