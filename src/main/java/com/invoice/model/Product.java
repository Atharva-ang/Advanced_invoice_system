package com.invoice.model;

import com.invoice.enums.ProductCategory;
import java.io.Serializable;

public abstract class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String name;
    protected double basePrice;
    protected int stockQuantity;
    protected ProductCategory category;

    public Product(String id, String name, double basePrice, int stockQuantity, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public void decreaseStock(int amount) {
        if (stockQuantity >= amount) this.stockQuantity -= amount;
        else throw new RuntimeException("Insufficient Stock");
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getBasePrice() { return basePrice; }
    public int getStockQuantity() { return stockQuantity; }
}