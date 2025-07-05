import java.time.LocalDate;

public class ExpiringProduct extends Product {
    private LocalDate expiryDate;

    public ExpiringProduct(String name, double price, int quantity, LocalDate expiryDate, boolean requiresShipping, double weight) {
        super(name, price, quantity, requiresShipping, weight);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
