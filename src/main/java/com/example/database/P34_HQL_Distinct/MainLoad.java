package com.example.database.P34_HQL_Distinct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class MainLoad {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Вывод уникальных имен студентов
            Query query = session.createQuery("select distinct s.name from Student s");
            List<String> names = query.list();
            for (String name : names) {
                System.out.println(name);
            }

            session.getTransaction().commit();

        }

    }
}
