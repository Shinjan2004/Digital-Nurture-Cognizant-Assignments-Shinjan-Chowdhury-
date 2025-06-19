package com.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventorylists<T> {
    private final List<T> items = new ArrayList<>();
    public void addItem(T item) {
        items.add(item);
    }
    public void removeItem(T item) {
        if (!items.contains(item)) throw new IllegalArgumentException("Item not found in inventory.");
        items.remove(item);
    }
    public void viewItems() {
        if (items.isEmpty()) System.out.println("Inventory is empty.");
        else {
            System.out.println("Inventory items:");
            for (T item : items) System.out.println(item);
        }
    }
    public List<T> getItems() {
        return items;
    }
}
