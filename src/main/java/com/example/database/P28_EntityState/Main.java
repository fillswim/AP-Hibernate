package com.example.database.P28_EntityState;

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
            System.out.println(student.getId()); // Id не назначен

            session.persist(student); // После этого Hibernate начинает отслеживать данный объект

            System.out.println(student.getId()); // Id назначен

//            session.flush(); // Объект сохраняется в БД, после этого изменения его не учитываются

//            student.setName("Nick"); // До коммита Hibernate будет отслеживать объект и обновлять его

//            session.detach(student); // Hibernate перестает следить за объектом

//            session.merge(student); // Возващение объекта в отслеживаемые

//            session.update(student); // Если не было flush(), то объект можно обновить

            session.remove(student); // Удаляет объект только из базы данных, в памяти java он остается

            session.refresh(student); // Откат состояния объекта к предыдущему изменению (до изменения поля)

            session.getTransaction().commit();

        }

    }
}
