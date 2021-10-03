package com.example.database.P19_NPlusOneProblem;


import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // LAZY инициализация объекта
    @LazyToOne(LazyToOneOption.NO_PROXY) // Решает проблему N+1 в отношении один-к-одному
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
