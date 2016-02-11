package drones;

import java.awt.Point;
import java.util.*;

/**
 * @author hjorthjort
 */
public class Order implements Comparable<Order> {
    // map from item ID to count
    List<Integer> items;
    public boolean done;
    public Point coordinates;

    public Order(int x, int y, int[] items) {
        this.coordinates = new Point(x, y);
        this.items = new ArrayList<>();
        for (int item : items) {
            this.items.add(item);
        }
    }

    public void load(int item) {
        items.remove(item);
    }

    public int getWeight() {
        int weight = 0;

        for (int item : items) {
            weight += Globals.productWeights[item];
        }

        return weight;
    }

    public void take(int item) {
        items.remove(item);
    }

    @Override
    public int compareTo(Order o) {
        return o.getWeight() - this.getWeight();
    }
}
