package Model;

public class Mask extends Equipment {
    private final int filterSize;

    public String toString() {
        return String.format("%s Mask(filter %d)", super.toString(), this.filterSize);
    }

    public Mask(int safetyLevel, int filterSize) {
        super(safetyLevel);
        this.filterSize = filterSize;
    }
}
