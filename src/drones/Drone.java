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

        while (loadedWeight + Globals.orders.peek().getWeight() < capacity) {
            Order takenOrder = Globals.orders.poll();
            currentOrders.add(takenOrder);
            loadedWeight += takenOrder.getWeight();
        }

        List<Warehouse> visited = new ArrayList<>();
        Warehouse nextW = Globals.getClosestWarehouse(position);
        while (!ordersDone()) {
            fori
            for (int i = 0; i < ; i++) {

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
