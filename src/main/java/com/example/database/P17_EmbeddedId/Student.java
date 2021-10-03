package com.example.database.P17_EmbeddedId;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Student {

    @EmbeddedId
    Address address = new Address();

    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String city, String street) {
        this.name = name;
        this.address.city = city;
        this.address.street = street;
    }
}
