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
    public boolean done;
    public Point coordinates;

    public Order(int x, int y, Map<Integer, Integer> items) {
        this.coordinates = new Point(x, y);
        this.items = items;

    }

    public void load(int item, int quant) {
        int currentQ = items.get(item);
        items.put(item, currentQ - quant);
    }

    public int getWeight() {
        int weight = 0;
        for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
            weight += Globals.productWeights[entry.getKey()] * entry.getValue();
        }
        return weight;
    }

    @Override
    public int compareTo(Order o) {
        return o.getWeight() - this.getWeight();
    }
}
