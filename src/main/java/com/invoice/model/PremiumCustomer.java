package com.invoice.model;

public class PremiumCustomer extends Customer {
    public PremiumCustomer(String id, String name, String email, String phone) {
        super(id, name, email, phone);
    }
    @Override
    public double getDiscountPercentage() { return 0.10; } // 10% Discount
}