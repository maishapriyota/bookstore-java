package Model;

public class Notebook extends Product {
    private final int pages;

    public String toString() {
        int var10000 = this.pages;
        return "" + var10000 + " pages notebook" + super.toString();
    }

    public Notebook(int price, int pages) {
        super(price);
        this.pages = pages;
    }
}
