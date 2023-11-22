package com.example.geektrust.Entities;


import java.util.Objects;

public class Customer {

    private final String userName;


    public Customer(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Customer && Objects.equals(userName, ((Customer) o).userName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

}
