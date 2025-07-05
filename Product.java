public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected boolean requiresShipping;
    protected double weight;

    public Product(String name, double price, int quantity, boolean requiresShipping, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.requiresShipping = requiresShipping;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean requiresShipping() { return requiresShipping; }
    public double getWeight() { return weight; }

    public void reduceQuantity(int qty) {
        this.quantity -= qty;
    }

    public abstract boolean isExpired();
}
