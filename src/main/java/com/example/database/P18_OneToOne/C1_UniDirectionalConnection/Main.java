package com.example.database.P18_OneToOne.C1_UniDirectionalConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Address address = new Address("Moscow", "Tverskaya str.");
            Student student = new Student("Mike");
            student.setAddress(address);

            session.persist(student);

            session.getTransaction().commit();

        }

    }
}
