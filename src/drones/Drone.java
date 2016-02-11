package drones;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hjorthjort
 */
public class Drone {
    static int capacity;
    Point position;
    List<Order> currentOrders = new ArrayList<>();

    public Drone(int xPos, int yPos) {
        position = new Point(xPos, yPos);
    }

    public String commands() {
        StringBuilder sb = new StringBuilder();
        int loadedWeight = 0;

        while (loadedWeight + Globals.orders.peek().weight < capacity) {
            currentOrders.add(Globals.orders.poll());
        }

        return sb.toString();
    }
}
