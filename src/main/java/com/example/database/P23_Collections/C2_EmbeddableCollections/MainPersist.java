package com.example.database.P23_Collections.C2_EmbeddableCollections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainPersist {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Address address1 = new Address("Moscow", "Tverskaya str.");
            Address address2 = new Address("Moscow", "Pushkina str.");
            Address address3 = new Address("Moscow", "Tchehova str.");

            List<Address> addresses = new ArrayList<>();
            addresses.add(address1);
            addresses.add(address2);
            addresses.add(address3);

            Student student = new Student("Mike");
            student.setAddresses(addresses);

            session.persist(student);

            session.getTransaction().commit();

        }

    }
}
