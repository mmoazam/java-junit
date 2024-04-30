package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart shoppingCart = new ShoppingCart();


    @Test
    void addItems() {
        shoppingCart.addItem("apple", 1.0);
        shoppingCart.addItem("banana", 2.0);
        shoppingCart.addItem("Orange", 3.0);

        Map<String, Double> expected = shoppingCart.getItems();

        assertNotNull(expected);
        assertEquals(3, expected.size());
        assertTrue(expected.containsKey("apple"));
        assertTrue(expected.containsKey("banana"));
        assertTrue(expected.containsKey("Orange"));
        assertEquals(1.0, expected.get("apple"));
        assertEquals(2.0, expected.get("banana"));
        assertEquals(3.0, expected.get("Orange"));
    }

    @Test
    // duplicate keys are not allowed in a hashmap. they are overwritten.
    @DisplayName("Add items with duplicates")
    void testAddItemsWithDuplicates() {
        shoppingCart.addItem("apple", 1.0);
        shoppingCart.addItem("apple", 2.0);
        shoppingCart.addItem("apple", 3.0);
        Map<String, Double> expected = shoppingCart.getItems();
        assertEquals(3, expected.get("apple"));
    }

    @Test
    void totalPrice() {
        shoppingCart.addItem("apple", 1.0);
        shoppingCart.addItem("banana", 2.0);
        shoppingCart.addItem("Orange", 3.0);
        assertEquals(6.0, shoppingCart.totalPrice());
    }

    @Test
    void totalZeroPrice() {
        shoppingCart.addItem("apple", 0.0);
        shoppingCart.addItem("banana", 0.0);
        shoppingCart.addItem("Orange", 0.0);
        assertEquals(0.0, shoppingCart.totalPrice());
    }

    @Test
    void addNegativePrice() {
        assertThrowsExactly(IllegalArgumentException.class, () -> shoppingCart.addItem("apple", -1.0));
    }

    @Test
    void emptyCart() {
        assertEquals(0.0, shoppingCart.totalPrice());
    }

    @Test
    void setShoppingCartDiscount() { //
        shoppingCart.setDiscount(0.5);
        assertEquals(0.5, shoppingCart.getDiscount());
    }

    @Test
    void setDiscountOutOfBoundsThrowsException() {
       assertThrowsExactly(IllegalArgumentException.class, () -> shoppingCart.setDiscount(-0.5));
       assertThrowsExactly(IllegalArgumentException.class, () -> shoppingCart.setDiscount(1.5));
    }

    @Test
    void setDiscountWithinBounds() {
        shoppingCart.setDiscount(0);
        assertEquals(0.0, shoppingCart.getDiscount());

        shoppingCart.setDiscount(1);
        assertEquals(1.0, shoppingCart.getDiscount());

        shoppingCart.setDiscount(0.75);
        assertEquals(0.75, shoppingCart.getDiscount());
    }

    @Test
    void calculateTotalWithDiscountZeroPercent() {
        shoppingCart.addItem("apple", 1.0);
        shoppingCart.addItem("banana", 2.0);
        shoppingCart.addItem("Orange", 3.0);
        shoppingCart.setDiscount(0.0);
        assertEquals(6.0, shoppingCart.totalPrice());
    }

    @Test
    void calculateTotalWithDiscountTenPercent() {
        shoppingCart.addItem("apple", 1.0);
        shoppingCart.addItem("banana", 2.0);
        shoppingCart.addItem("Orange", 3.0);
        shoppingCart.setDiscount(0.1);
        assertEquals(5.4, shoppingCart.totalPrice());
    }
}