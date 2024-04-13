package Model;

public class Gloves extends Equipment {
    private final int size;

    public String toString() {
        return String.format("%s Gloves(size %d)", super.toString(), this.size);
    }

    public Gloves(int safetyLevel, int size) {
        super(safetyLevel);
        this.size = size;
    }
}
