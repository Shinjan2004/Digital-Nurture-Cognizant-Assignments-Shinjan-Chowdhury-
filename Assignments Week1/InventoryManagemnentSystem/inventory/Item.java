package com.inventory;

public class Item {
    private int productId;
    private double price;
    private String productName;
    private int quantity;

    public Item(int productId, double price, String productName, int quantity) {
        this.productId = productId;
        this.price = price;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Item{ID='" + productId + "', name='" + productName + "', quantity=" + quantity + ", price=" + price + "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item that = (Item) o;
        return productId == that.productId;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(productId);
    }
}
