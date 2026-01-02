package com.invoice.service;

import com.invoice.model.Invoice;
import java.util.*;
import java.util.stream.Collectors;

public class AnalyticsService {

    public void printTopCustomers(List<Invoice> invoices) {
        System.out.println("\n--- Top Customers by Spend ---");
        Map<String, Double> customerSpend = invoices.stream()
                .collect(Collectors.groupingBy(
                        inv -> inv.getCustomer().getName(),
                        Collectors.summingDouble(Invoice::getTotalAmount)
                ));

        customerSpend.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.printf("%s: $%.2f%n", entry.getKey(), entry.getValue()));
    }

    public void printTotalRevenue(List<Invoice> invoices) {
        double total = invoices.stream()
                .mapToDouble(Invoice::getTotalAmount)
                .sum();
        System.out.printf("\nTotal Revenue: $%.2f%n", total);
    }
}