package Model;

public abstract class Equipment implements Comparable<Equipment> {
    private final int safetyLevel;

    public int compareTo(Equipment o) {
        return this.safetyLevel - o.safetyLevel;
    }

    public String toString() {
        return String.format("safetyLevel_%d", this.safetyLevel);
    }

    public Equipment(int safetyLevel) {
        this.safetyLevel = safetyLevel;
    }
}
