package drones;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hjorthjort
 */
public class Drone {
    static int capacity;
    int id;
    Point position;
    Order currentOrder;

    public Drone(int id, int xPos, int yPos) {
        position = new Point(xPos, yPos);
    }

    public String commands() {
        StringBuilder sb = new StringBuilder();
        Order order = Globals.orders.poll();
        List<Warehouse> visited = new LinkedList<>();
        while (order.getWeight() > 0) {
            Warehouse closestW = Globals.getClosestWarehouse(position, visited);
            for (int item : order.items) {
                if (closestW.has(item)) {
                    sb.append("L " + closestW.id + " " + item + " 1\n");
                    closestW.take(item);
                    order.take(item);
                }
            }
            visited.add(closestW);
        }
        for (int item : order.items) {
            sb.append("D " + order.id + " " + item + " 1\n");
        }
        return sb.toString();
    }
}
