package com.example.database.P23_Collections.C2_EmbeddableCollections;

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

    @Override
    public String toString() {
        return "\nAddress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
