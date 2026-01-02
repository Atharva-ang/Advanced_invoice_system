package com.invoice.model;

public class RegularCustomer extends Customer {
    public RegularCustomer(String id, String name, String email, String phone) {
        super(id, name, email, phone);
    }
    @Override
    public double getDiscountPercentage() { return 0.0; }
}