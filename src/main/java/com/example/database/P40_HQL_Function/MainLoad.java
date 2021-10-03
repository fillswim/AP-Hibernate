package com.example.database.P40_HQL_Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class MainLoad {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Вывод максимального id
            Query query = session.createQuery("select max(id) from Student s");
//            Query query = session.createQuery("select min(id) from Student s");
//            Query query = session.createQuery("select count(id) from Student s");
//            Query query = session.createQuery("select sum(id) from Student s");
//            Query query = session.createQuery("select avg(id) from Student s");

            // JPQL
//            Query query = session.createQuery("select abs(id) from Student s");
//            Query query = session.createQuery("select mod(id) from Student s");
//            Query query = session.createQuery("select sqrt(id) from Student s");
            Integer result = (Integer) query.uniqueResult();
            System.out.println(result);

//            Query query = session.createQuery("select concat(id, ' id') from Student s");
//            Query query = session.createQuery("select substring(name, 1, 2) from Student s");
//            Query query = session.createQuery("select upper(name) from Student s");
//            Query query = session.createQuery("select lower(name) from Student s");
//            Query query = session.createQuery("select trim(name) from Student s");
//            Query query = session.createQuery("select length(name) from Student s");
//            Query query = session.createQuery("select length(name) from Student s");
//            Query query = session.createQuery("select locate('e', name) from Student s");

//            Query query = session.createQuery("select current_date from Student s");
//            Query query = session.createQuery("select current_time from Student s");
//            Query query = session.createQuery("select current_timestamp from Student s");

            // HQL
            // Битовая длина
//            Query query = session.createQuery("select cast(id as string) from Student s");
//            Query query = session.createQuery("select extract(YEAR from current_timestamp ) from Student s");

//            List<String> strings = query.list();
//            for (String s : strings) {
//                System.out.println(s);
//            }


            session.getTransaction().commit();

        }

    }
}
