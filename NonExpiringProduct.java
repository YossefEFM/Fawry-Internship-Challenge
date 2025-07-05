public class NonExpiringProduct extends Product {
    public NonExpiringProduct(String name, double price, int quantity, boolean requiresShipping, double weight) {
        super(name, price, quantity, requiresShipping, weight);
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
