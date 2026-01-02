package com.invoice.main;

import com.invoice.enums.ProductCategory;
import com.invoice.model.*;
import com.invoice.service.AnalyticsService;
import com.invoice.service.InventoryManager;

import java.util.Scanner;

public class Main {
    private static final InventoryManager manager = new InventoryManager();
    private static final AnalyticsService analytics = new AnalyticsService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        manager.loadData();
        if (manager.getAllProducts().isEmpty()) seedData();

        while (true) {
            System.out.println("\n=== INVOICE SYSTEM ===");
            System.out.println("1. Add Customer");
            System.out.println("2. View Products");
            System.out.println("3. Create Invoice");
            System.out.println("4. View Reports");
            System.out.println("5. Save & Exit");
            System.out.print("Select: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Fix newline bug

            switch (choice) {
                case 1: handleAddCustomer(); break;
                case 2: handleViewProducts(); break;
                case 3: handleCreateInvoice(); break;
                case 4: handleReports(); break;
                case 5:
                    manager.saveData();
                    System.out.println("Goodbye!");
                    return;
                default: System.out.println("Invalid.");
            }
        }
    }

    private static void seedData() {
        manager.addProduct(new PhysicalProduct("P01", "Laptop", 1200.0, 10, ProductCategory.ELECTRONICS));
        manager.addProduct(new PhysicalProduct("P02", "Book", 20.0, 50, ProductCategory.BOOKS));
        manager.addCustomer(new RegularCustomer("C01", "John Doe", "john@test.com", "123"));
        System.out.println("Sample data loaded.");
    }

    private static void handleAddCustomer() {
        System.out.print("ID: "); String id = scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Type (1-Reg, 2-Prem): ");
        int type = scanner.nextInt();
        Customer c = (type == 2) ? new PremiumCustomer(id, name, "na", "na")
                : new RegularCustomer(id, name, "na", "na");
        manager.addCustomer(c);
        System.out.println("Added.");
    }

    private static void handleViewProducts() {
        for (Product p : manager.getAllProducts()) {
            System.out.println(p.getId() + " | " + p.getName() + " | Stock: " + p.getStockQuantity());
        }
    }

    private static void handleCreateInvoice() {
        System.out.print("Customer ID: ");
        Customer c = manager.findCustomer(scanner.nextLine());
        if (c == null) { System.out.println("Not found."); return; }

        Invoice inv = new Invoice("INV" + System.currentTimeMillis(), c);

        while(true) {
            System.out.print("Product ID (or 'done'): ");
            String pid = scanner.nextLine();
            if(pid.equals("done")) break;

            Product p = manager.findProduct(pid);
            if(p != null) {
                System.out.print("Qty: ");
                int qty = scanner.nextInt();
                scanner.nextLine();
                try {
                    p.decreaseStock(qty);
                    inv.addItem(p, qty);
                    System.out.println("Added.");
                } catch(Exception e) { System.out.println(e.getMessage()); }
            }
        }
        inv.calculateTotal();
        manager.addInvoice(inv);
        System.out.println("Invoice Saved. Total: " + inv.getTotalAmount());
    }

    private static void handleReports() {
        analytics.printTopCustomers(manager.getAllInvoices());
        analytics.printTotalRevenue(manager.getAllInvoices());
    }
}