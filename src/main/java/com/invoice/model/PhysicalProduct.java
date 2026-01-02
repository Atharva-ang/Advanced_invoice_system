package com.invoice.model;
import com.invoice.enums.ProductCategory;

public class PhysicalProduct extends Product {
    public PhysicalProduct(String id, String name, double price, int stock, ProductCategory cat) {
        super(id, name, price, stock, cat);
    }
}