package com.invoice.model;

public class CorporateCustomer extends Customer {
    public CorporateCustomer(String id, String name, String email, String phone) {
        super(id, name, email, phone);
    }
    @Override
    public double getDiscountPercentage() { return 0.15; } // 15% Discount
}