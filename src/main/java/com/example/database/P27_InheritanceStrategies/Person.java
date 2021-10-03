package com.example.database.P27_InheritanceStrategies;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "ClassName") // Изменение названия поля с названием классв в БД
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // По умолчанию. Все наследуемые классы сохраняются в одну таблицу
//@Inheritance(strategy = InheritanceType.JOINED) // объекты и их классы разбиваются на связанные таблицы
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Для каждого класса будет отдельная таблица
public class Person {

    @Id
    @GeneratedValue
    int id;
    int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }
}
