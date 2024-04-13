package Model;

public class Box {
    private int itemCount;
    private String itemType;
    private int productionDate;

    public int setItemCount(int itemCount) {
        this.itemCount = itemCount;
        return itemCount;
    }

    public int getProductionDate() {
        return this.productionDate;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public String getItemType() {
        return this.itemType;
    }

    public String toString() {
        return "[" + this.itemType + ", " + this.itemCount + ", " + this.productionDate + "]";
    }

    public Box(String itemType, int itemCount, int productionDate) {
        this.itemCount = itemCount;
        this.itemType = itemType;
        this.productionDate = productionDate;
    }
}
