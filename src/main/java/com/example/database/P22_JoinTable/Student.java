package com.example.database.P22_JoinTable;


import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( // меняется название столбцов в таблице для связи таблиц
            joinColumns = @JoinColumn(name = "studId"),
            inverseJoinColumns = @JoinColumn(name = "homeId")
    )
    List<Address> addresses;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<Address> addresses) {
        this.name = name;
        this.addresses = addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
