package org.example;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items;
    private double MAX_VALUE = 10.0;

    public ShoppingCart(Map<String, Double> items, double discount) {
        this.items = items;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) throws IllegalArgumentException {

        if (discount < 0.0 || discount > 1.0)
            throw new IllegalArgumentException("Discount must be between 0.0 and 1.0");

        this.discount = discount;

    }

    private double discount;

    public Map<String, Double> getItems() {
        return items;
    }

    public void addItem(String item, double price) throws IllegalArgumentException {

        if (price < 0.0)
            throw new IllegalArgumentException("Price cannot be negative");

        items.put(item, price);
    }

    public double totalPrice() throws IllegalArgumentException {
        double total = 0.0;
        for (Map.Entry<String, Double> entry : items.entrySet()) {
            total += entry.getValue();
        }

        if(applyDiscount(total) > MAX_VALUE)
            throw new IllegalArgumentException("Total price cannot be more than " + MAX_VALUE);

        return applyDiscount(total);
    }

    public double applyDiscount(double total) {

            return total * (1 - discount);

    }
}
