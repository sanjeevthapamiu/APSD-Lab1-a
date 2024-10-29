package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;

public class Product {

    private long productId;
    private String name;
    private LocalDate dateSupplied;
    private int quantity;
    private float unitPrice;

    public Product() {}

    public Product(long productId, String name, LocalDate dateSupplied, int quantity, float unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", dateSupplied=" + dateSupplied +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
