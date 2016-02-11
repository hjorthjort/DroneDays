package drones;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hjorthjort
 */
public class Order implements Comparable<Order> {
    // map from item ID to count
    Map<Integer, Integer> items = new HashMap<>();
    public int weight = 0;
    public boolean done;
    public Point coordinates;

    public Order(int x, int y, Map<Integer, Integer> items) {
        this.coordinates = new Point(x, y);
        this.items = items;

        for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
            this.weight += Globals.productWeights[entry.getKey()] * entry.getValue();
        }
    }

    @Override
    public int compareTo(Order o) {
        return o.weight - this.weight;
    }
}
