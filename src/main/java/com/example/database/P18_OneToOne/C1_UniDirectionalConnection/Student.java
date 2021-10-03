package com.example.database.P18_OneToOne.C1_UniDirectionalConnection;


import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne(cascade = CascadeType.REMOVE) // При удалении student удалится и address
//    @OneToOne(cascade = CascadeType.PERSIST) // Будет каскадное сохранение
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
