package com.example.database.P21_ManyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue
    int id;

    String city;
    String street;

    @ManyToMany
    List<Student> students;

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
