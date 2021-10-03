package com.example.database.P24_SortCollections;


import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @ElementCollection
    @OrderBy("marks") // Сортировка при выводе из БД. Значения будут отсортированы при получении значений из БД
//    @OrderColumn // Запоминает порядок сохранения в БД
    List<Integer> marks;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
