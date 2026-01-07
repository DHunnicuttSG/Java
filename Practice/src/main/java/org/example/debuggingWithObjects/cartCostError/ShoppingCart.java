package org.example.debuggingWithObjects.cartCostError;

public class ShoppingCart {
    Item[] items;

    ShoppingCart(Item[] items) {
        this.items = items;
    }

    double totalPrice() {
        double total = 0;
        for (int i = 1; i < items.length - 1; i++) {
            total += items[i].price;
        }
        return total;
    }
}
