package com.invoice.model;
import com.invoice.enums.ProductCategory;

public class DigitalProduct extends Product {
    public DigitalProduct(String id, String name, double price, ProductCategory cat) {
        super(id, name, price, 999999, cat); // Unlimited stock
    }
}