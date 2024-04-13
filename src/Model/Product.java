package Model;

public abstract class Product implements Comparable<Product> {
    private final int price;

    public int compareTo(Product o) {
        return this.price - o.price;
    }

    public String toString() {
        return String.format("(%d)", this.price);
    }

    public Product(int price) {
        this.price = price;
    }
}
