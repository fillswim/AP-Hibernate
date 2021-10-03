package com.example.database.P38_HQL_Join;

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

            // Загрузка пользователей из БД (join не особо используется для загрузке из БД)
            Query query = session.createQuery("from User");

            List<User> users = query.list();
            for (User user : users) {
                System.out.println(user);
            }

            session.getTransaction().commit();

        }

    }
}
