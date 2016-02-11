package drones;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hjorthjort
 */
public class Order implements Comparable<Order> {
    Map<Integer, Integer> items = new HashMap<>();
    public int weight = 0;
    public boolean done;
    public int x;
    public int y;

    public Order(int x, int y, Map<Integer, Integer> items) {
        this.x = x;
        this.y = y;
        this.items = items;

        for (int weight : items.values()) {
            this.weight += weight;
        }
    }

    @Override
    public int compareTo(Order o) {
        return o.weight - this.weight;
    }
}
