package drones;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hjorthjort
 */
public class Warehouse {
    Map<Integer, Integer> items = new HashMap<>();
    Point coordinates;
    int id;

    Warehouse(int id, int xCoord, int yCoord) {
        coordinates = new Point(xCoord, yCoord);
    }

    public void addItem(int itemNbr, int quantity) {
        items.put(itemNbr, quantity);
    }
}
