package com.example.database.P20_OneToMany_ManyToOne.C1_UniDirectionalConnection;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId") // Название для столбца в таблице address, через которое будут связываться таблицы
    List<Address> addresses = new ArrayList<>();

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
