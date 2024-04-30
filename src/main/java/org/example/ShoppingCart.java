package org.example;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items = new HashMap<String, Double>();

    public Map<String, Double> getItems() {
        return items;
    }

    public void addItem(String item, double price) {
        items.put(item, price);
    }

    public void totalPrice() {}

}
