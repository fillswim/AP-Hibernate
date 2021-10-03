package com.example.database.P09_TimeStampGeneration;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;


//    @CreationTimestamp // При сохранении в БД будет еще записываться дата
    @UpdateTimestamp   // При каждом обновлении данных будет обновляться поле даты
    Date date;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Date date) {
        this.name = name;
        this.date = date;
    }
}
