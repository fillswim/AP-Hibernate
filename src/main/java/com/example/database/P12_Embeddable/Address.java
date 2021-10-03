package com.example.database.P12_Embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    String city;
    String street;

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}
