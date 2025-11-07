package org.example.debuggingWithObjects.cartCostError;

public class App {
    // Something is not quite right here,  find the error and fix it.
    public static void main(String[] args) {
        Item[] list = {
                new Item("Gum", 0.40),
                new Item("Lettuce", 0.75),
                new Item("Apple", 1.20),
                new Item("Banana", 0.80),
                new Item("Milk", 2.50),
                new Item("Cookie", 1.20),
                new Item("Tomato", 0.75),
                new Item("Candy", 0.30)
        };
        ShoppingCart cart = new ShoppingCart(list);
        System.out.println("Total: " + cart.totalPrice());
    }
}
