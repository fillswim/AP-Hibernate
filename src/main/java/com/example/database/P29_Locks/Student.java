package com.example.database.P29_Locks;


import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
// При попытке записи чтения и перезаписи значения в БД поле в БД будет блокироваться
// и при последующей записи значения сравниваться версия объекта
// @OptimisticLocking - используется, если читаются данные часто, а записываются редко
//@OptimisticLocking(type = OptimisticLockType.ALL) // Сверяются все поля
@OptimisticLocking(type = OptimisticLockType.VERSION) // Используется версия объекта

// LockMode.PESSIMISTIC_WRITE добавляется в метод load() при загрузке данных из БД

public class Student {

    @Id
    @GeneratedValue
    int id;
    String number;

    // Добавление версии для решения проблемы локов
    @Version
    int version;

    public Student() {
    }

    public Student(String number) {
        this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
