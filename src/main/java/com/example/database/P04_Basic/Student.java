package com.example.database.P04_Basic;


import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;

    // параметр является обязательным и загружается только по требованию
    @Basic(optional = false, fetch = FetchType.LAZY)
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
