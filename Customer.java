import java.util.*;

public class Customer {
    private String name;
    private double balance;
    private List<CartItem> cart = new ArrayList<>();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void addToCart(Product product, int qty) {
        if (product.isExpired()) {
            throw new IllegalStateException(product.getName() + " is expired.");
        }
        if (qty > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        }
        cart.add(new CartItem(product, qty));
    }

    public void checkout() {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty!");
        }

        double subtotal = 0;
        double shippingFees = 0;
        List<Shippable> itemsToShip = new ArrayList<>();

        for (CartItem item : cart) {
            Product p = item.getProduct();
            if (p.isExpired()) {
                throw new IllegalStateException("Product " + p.getName() + " is expired.");
            }
            if (item.getQuantity() > p.getQuantity()) {
                throw new IllegalStateException("Not enough quantity for " + p.getName());
            }

            subtotal += item.getTotalPrice();

            if (p.requiresShipping()) {
                shippingFees += item.getQuantity() * p.getWeight() * 27.27;
                for (int i = 0; i < item.getQuantity(); i++) {
                    Product finalP = p;
                    itemsToShip.add(new Shippable() {
                        public String getName() { return finalP.getName(); }
                        public double getWeight() { return finalP.getWeight(); }
                    });
                }
            }
        }

        double total = subtotal + shippingFees;

        if (balance < total) {
            throw new IllegalStateException("Insufficient balance.");
        }

        this.balance -= total;
        for (CartItem item : cart) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
         if (!itemsToShip.isEmpty()) {
            System.out.println();
            ShippingService.process(itemsToShip);
        }
        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart) {
            System.out.printf("%dx %-13s %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f\n", subtotal);
        System.out.printf("Shipping         %.0f\n", shippingFees);
        System.out.printf("Amount           %.0f\n", total);

       

        cart.clear();
    }
}
