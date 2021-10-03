package com.example.database.P38_HQL_Join;

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

            // Создание пользователя
            User user = new User("Mike");

            // Создание ролей
            Role role1 = new Role("Administrator");
            Role role2 = new Role("User");

            // Создание списка ролей
            List<Role> roles = new ArrayList<>();
            roles.add(role1);
            roles.add(role2);

            // Добавление списка ролей пользователю
            user.setRoles(roles);

            // Сохранение пользователя
            session.persist(user);

            session.getTransaction().commit();

        }

    }
}
