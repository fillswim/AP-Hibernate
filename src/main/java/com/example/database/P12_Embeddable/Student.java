package com.example.database.P12_Embeddable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    Address address = new Address();

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
