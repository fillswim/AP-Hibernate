package com.example.database.P20_OneToMany_ManyToOne.C2_BiDirectionalConnection;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    int id;

    String city;
    String street;

    @ManyToOne
    Student student;

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
