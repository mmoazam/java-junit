package org.example;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items = new HashMap<String, Double>();

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {

        if (discount < 0.0 || discount > 1.0)
            throw new IllegalArgumentException("Discount must be between 0.0 and 1.0");

        this.discount = discount;

    }

    private double discount;

    public Map<String, Double> getItems() {
        return items;
    }

    public void addItem(String item, double price) {

        if (price < 0.0)
            throw new IllegalArgumentException("Price cannot be negative");

        items.put(item, price);
    }

    public double totalPrice() {
        double total = 0.0;
        for (Map.Entry<String, Double> entry : items.entrySet()) {
            total += entry.getValue();
        }

        return applyDiscount(total);
    }

    public double applyDiscount(double total) {

            return total * (1 - discount);

    }
}
