package com.example.database.P18_OneToOne.C2_BiDirectionalConnection;


import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @OneToOne(cascade = CascadeType.ALL)
    Address address = new Address();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
