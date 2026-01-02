package com.invoice.model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String name;
    protected String email;
    protected String phone;
    protected LocalDate registrationDate;

    public Customer(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.registrationDate = LocalDate.now();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public abstract double getDiscountPercentage();

    @Override
    public String toString() { return id + " | " + name + " | " + email; }
}