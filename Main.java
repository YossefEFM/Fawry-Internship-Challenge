import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new ExpiringProduct("Cheese", 100, 10, LocalDate.now().plusDays(3), true, 0.2);
        Product biscuits = new ExpiringProduct("Biscuits", 150, 5, LocalDate.now().plusDays(2), true, 0.7);
        Product scratchCard = new NonExpiringProduct("Scratch Card", 20, 20, false, 0);

        Customer customer = new Customer("Yossef", 1000);

        try {
            customer.addToCart(cheese, 2);
            customer.addToCart(biscuits, 1);
            customer.checkout();
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }
}
