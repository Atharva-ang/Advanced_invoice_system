package com.invoice.service;

import com.invoice.model.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class InventoryManager {
    private List<Customer> customers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();
    private final String DATA_FILE = "system_data.ser";

    public void addCustomer(Customer c) { customers.add(c); }
    public Customer findCustomer(String id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public void addProduct(Product p) { products.add(p); }
    public Product findProduct(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
    public List<Product> getAllProducts() { return products; }

    public void addInvoice(Invoice inv) { invoices.add(inv); }
    public List<Invoice> getAllInvoices() { return invoices; }

    // Save Data to File
    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(customers);
            oos.writeObject(products);
            oos.writeObject(invoices);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load Data from File
    @SuppressWarnings("unchecked")
    public void loadData() {
        File f = new File(DATA_FILE);
        if(!f.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            customers = (List<Customer>) ois.readObject();
            products = (List<Product>) ois.readObject();
            invoices = (List<Invoice>) ois.readObject();
            System.out.println("Data loaded successfully.");
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}