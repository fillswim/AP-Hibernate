package com.example.database.P15_Transient;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Address {

    String city;

    // Поле street не будет сохраняться в БД
    @Transient
    String street;

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}
