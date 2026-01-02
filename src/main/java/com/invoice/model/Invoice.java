package com.invoice.model;

import com.invoice.enums.PaymentMethod;
import com.invoice.enums.TaxType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    private String invoiceId;
    private Customer customer;
    private Map<Product, Integer> items;
    private LocalDateTime date;
    private double totalAmount;

    public Invoice(String invoiceId, Customer customer) {
        this.invoiceId = invoiceId;
        this.customer = customer;
        this.date = LocalDateTime.now();
        this.items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        items.put(product, quantity);
    }

    public double calculateTotal() {
        double subtotal = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            subtotal += entry.getKey().getBasePrice() * entry.getValue();
        }

        double discount = subtotal * customer.getDiscountPercentage();
        double afterDiscount = subtotal - discount;
        double tax = afterDiscount * TaxType.GST.getRate(); // Default 18% Tax

        this.totalAmount = afterDiscount + tax;
        return this.totalAmount;
    }

    public Customer getCustomer() { return customer; }
    public double getTotalAmount() { return totalAmount; }
    public String getInvoiceId() { return invoiceId; }

    @Override
    public String toString() {
        return "Invoice: " + invoiceId + " | Customer: " + customer.getName() + " | Total: $" + String.format("%.2f", totalAmount);
    }
}