package com.example.database.P16_Id;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.TABLE) // Будет создаваться отдельная таблица для Id
    int id;
//    UUID uuid; // длинная последовательность в качестве Id
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
