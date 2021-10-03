package com.example.database.P20_OneToMany_ManyToOne.C2_BiDirectionalConnection;

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
            Address address1 = new Address("Moscow", "Tverskaya str.");
            Address address2 = new Address("Moscow", "Pushkina str.");
            Address address3 = new Address("Moscow", "Tchehova str.");

            // Сохдание студента
            Student student = new Student("Mike");

            // Добавление студента к адресу
            address1.setStudent(student);
            address2.setStudent(student);
            address3.setStudent(student);

            // Добавление адресов в список
            List<Address> addresses = new ArrayList<>();
            addresses.add(address1);
            addresses.add(address2);
            addresses.add(address3);

            // Добавление списка адресов студенту
            student.setAddresses(addresses);

            session.persist(student);

            session.getTransaction().commit();

        }

    }
}
