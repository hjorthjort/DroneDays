package drones;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hjorthjort
 */
public class Drone {
    static int capacity;
    int id;
    Point position;
    List<Order> currentOrders = new ArrayList<>();

    public Drone(int id, int xPos, int yPos) {
        position = new Point(xPos, yPos);
    }

    public String commands() {
        StringBuilder sb = new StringBuilder();
        int loadedWeight = 0;

        while (loadedWeight + Globals.orders.peek().getWeight() < capacity) {
            Order takenOrder = Globals.orders.poll();
            currentOrders.add(takenOrder);
            loadedWeight += takenOrder.getWeight();
        }

        List<Warehouse> visited = new ArrayList<>();
        Warehouse nextW = Globals.getClosestWarehouse(position);
        while (!ordersDone()) {
            for (Order order : currentOrders) {
                for (int i = 0; i < order.items.size(); i++) {
                    if (nextW.items.containsKey(order.items.get(i))) {
                        sb.append(id + " L " + nextW.id + " " + order.items.get(i) + " 1");
                    }
                }
            }
        }

        return sb.toString();
    }

    private boolean ordersDone() {
        for (Order o : currentOrders) {
            if (o.getWeight() != 0) {
                return false;
            }
        }
        return true;
    }
}
