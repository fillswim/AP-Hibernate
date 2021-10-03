package com.example.database.P10_LoadGet;

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
            session.save(student);

            // При указании неправильного id будет выброшено исключение
            // Загружает пустой объект
            Student studentLoad = session.load(Student.class, 1);
            System.out.println(studentLoad);

            // При указании неправильного id get возвращает null
            Student studentGet = session.get(Student.class, 1);
            System.out.println(studentGet);

            session.getTransaction().commit();

        }

    }
}
