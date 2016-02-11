package drones;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author hjorthjort
 */
public class Globals {
    static List<Warehouse> whs = new ArrayList<>();
    static PriorityQueue<Order> orders = new PriorityQueue<>();
    static List<Drone> drones = new ArrayList<>();
    static int[] productWeights;

    static long distance(Point a, Point b) {
        return Math.round(Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)));
    }

    public static Warehouse getClosestWarehouse(Point position) {
        Warehouse ret = whs.get(0);
        long shortest = distance(ret.coordinates, position);
        for (int i = 1; i < whs.size(); i++) {
            long dist = distance(whs.get(i).coordinates, position);
            if (dist < shortest) {
                ret = whs.get(i);
                shortest = dist;
            }
        }
        return ret;
    }
}
