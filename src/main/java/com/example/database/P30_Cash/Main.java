package com.example.database.P30_Cash;

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

            Student student = new Student("Mike");
            session.persist(student);

            Student loadStudent = session.load(Student.class, 1); // Запрос отрабатывается на кэше 1-го уровня
            System.out.println(loadStudent);

            // Hibernate не имеет кэш второго уровня, его необходимо подключать от сторонних разработчиков

            session.getTransaction().commit();

        }

    }
}
