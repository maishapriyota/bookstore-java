package Model;

import java.util.Random;

public class BoxPackaging {
    Random random = new Random();

    public BoxPackaging() {
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (double)(end - start));
    }

    public static int createProductionDate() {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(1000, 2022);
        String productDate = String.format("%d%02d%02d", year, month, day);
        return Integer.parseInt(productDate);
    }

    public static Box createBox(String itemType, int itemCount) {
        int productionDate = createProductionDate();
        return new Box(itemType, itemCount, productionDate);
    }
}
