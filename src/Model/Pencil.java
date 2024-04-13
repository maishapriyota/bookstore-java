package Model;

public class Pencil extends Product {
    private final String color;

    public String toString() {
        String var10000 = this.color;
        return var10000 + " pencil" + super.toString();
    }

    public Pencil(int price, String color) {
        super(price);
        this.color = color;
    }
}
