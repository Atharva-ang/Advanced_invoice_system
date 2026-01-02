package com.invoice.enums;

public enum TaxType {
    GST(0.18), VAT(0.05), SERVICE_TAX(0.12), NONE(0.0);

    private final double rate;
    TaxType(double rate) { this.rate = rate; }
    public double getRate() { return rate; }
}