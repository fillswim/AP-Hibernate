package com.example.database.P18_OneToOne.C2_BiDirectionalConnection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

    @Id
    @GeneratedValue
    int id;

    String city;
    String street;

    @OneToOne(mappedBy = "address") // address будет не знать о student
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
