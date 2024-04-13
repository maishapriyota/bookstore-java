package Model;

import java.util.ArrayList;

public class ItemStorage<T extends Comparable<? super T>> {
    private ArrayList<T> items = new ArrayList();

    public void add(T item) {
        this.items.add(item);
    }

    public String get() {
        int i = this.items.size() - 1;
        return String.valueOf(this.items.get(i));
    }

    public ItemStorage() {
    }
}
