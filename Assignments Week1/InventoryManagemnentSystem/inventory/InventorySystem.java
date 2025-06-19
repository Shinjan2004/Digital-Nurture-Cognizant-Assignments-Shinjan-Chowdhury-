package com.inventory;

import java.util.Scanner;

public class InventorySystem {
    public static void main(String[] args) {
        Inventorylists<Item> inventory = new Inventorylists<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nInventory System");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. View items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter item ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Item newItem = new Item(id, price, name, quantity);
                    inventory.addItem(newItem);
                    System.out.println("Item added successfully: " + newItem);
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemNameToRemove = scanner.nextLine();
                    Item itemToRemove = null;
                    for (Item item : inventory.getItems()) {
                        if (item.getProductName().equalsIgnoreCase(itemNameToRemove)) {
                            itemToRemove = item;
                            break;
                        }
                    }
                    if (itemToRemove != null) {
                        inventory.removeItem(itemToRemove);
                        System.out.println("Item removed successfully: " + itemToRemove);
                    } else {
                        System.out.println("Item not found in inventory.");
                    }
                    break;
                case 3:
                    inventory.viewItems();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Inventory System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
