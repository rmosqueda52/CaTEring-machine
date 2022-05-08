package com.techelevator.models;

public class Item {
    private int quantity = 7;
    private String name;
    private double price;
    private String slot;
    private String type;

    public Item(String slot, String name, String type, double price) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSlot() {
        return slot;
    }

    public String getType() {
        return type;
    }

    public String itemNamePriceString(){
        return getName() + " Price: $" + getPrice();
    }
}
