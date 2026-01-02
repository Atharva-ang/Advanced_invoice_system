# 🧾 Invoice Management System

A comprehensive Java-based console application designed to manage customers, inventory, invoices, and analytics for a small business. This system demonstrates core Object-Oriented Programming (OOP) principles including Inheritance, Polymorphism, Java Streams API, and File Persistence.

## 🚀 Features

### 1. Customer Management
* **Inheritance Model:** distinct customer types (`Regular`, `Premium`, `Corporate`).
* **Polymorphism:** Unique discount strategies for each customer type.
    * *Regular:* 0% Discount
    * *Premium:* 10% Discount
    * *Corporate:* 15% Discount

### 2. Product Management
* **Categorization:** Products categorized via Enums (`ELECTRONICS`, `CLOTHING`, `BOOKS`, etc.).
* **Stock Tracking:** Automatic stock deduction upon invoice generation.
* **Validation:** Prevents sales if stock is insufficient.

### 3. Invoice Generation
* **Dynamic Calculation:** Automatically calculates Subtotal, Discounts (based on customer), and Tax.
* **Tax System:** Implements GST (18%) strategy.
* **Itemization:** Supports multiple products per single invoice.

### 4. Data Persistence (File I/O)
* **Serialization:** All data (Customers, Products, Invoices) is saved to `system_data.ser` automatically upon exit.
* **Auto-Load:** Data is restored seamlessly when the application restarts.

### 5. Analytics & Reporting
* **Java Streams:** utilized to generate high-performance reports.
* **Top Customers:** Identifies high-value clients based on total spend.
* **Revenue Analysis:** Calculates total business revenue.

---

## 🛠️ Tech Stack
* **Language:** Java 8+ (Tested on JDK 17)
* **Concepts:** OOP, Collections Framework, Stream API, Serialization
* **Interface:** Console-based UI (CLI)

---

## 📂 Project Structure

The source code is organized into the following packages:

```text
src/
└── com/
    └── invoice/
        ├── enums/       # Constants (TaxType, PaymentMethod, ProductCategory)
        ├── model/       # Entity classes (Customer, Product, Invoice)
        ├── service/     # Business Logic (InventoryManager, AnalyticsService)
        └── main/        # Entry point (Main.java)