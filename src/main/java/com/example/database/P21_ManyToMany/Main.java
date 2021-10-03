package com.example.database.P21_ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Создание адресов
            Address address = new Address("Moscow", "Tverskaya str.");

            // Создание студентов
            Student student = new Student("Mike");

            // Создание списка адресов
            List<Address> addresses = new ArrayList<>();
            addresses.add(address);

            // Создание списка студентов
            List<Student> students = new ArrayList<>();
            students.add(student);

            // Добавление списка студентов адресу
            address.setStudents(students);

            // Добавление списка адресов студенту
            student.setAddresses(addresses);

            session.persist(student);

            session.getTransaction().commit();

        }

    }
}
