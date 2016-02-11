package drones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mats on 11/02/16.
 */
public class Delivery {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("files/busy_day.in"));

            int line = 0;

            int rows = Integer.parseInt(lines.get(line).split(" ")[0]);
            int cols = Integer.parseInt(lines.get(line).split(" ")[1]);
            int numberOfDrones = Integer.parseInt(lines.get(line).split(" ")[2]);
            int deadline = Integer.parseInt(lines.get(line).split(" ")[3]);
            int maxLoad = Integer.parseInt(lines.get(line).split(" ")[4]);

            line += 1;

            int numberOfProductTypes = Integer.parseInt(lines.get(line));
            int[] productWeights = Arrays.stream(lines.get(line + 1).split(" ")).mapToInt(Integer::parseInt).toArray();
            Globals.productWeights = productWeights;

            line += 2;

            int numberOfWarehouses = Integer.parseInt(lines.get(line));

            line += 1;

            // warehouses
            for (int i = 0; i < numberOfWarehouses; i++) {
                int x = Integer.parseInt(lines.get(line).split(" ")[0]);
                int y = Integer.parseInt(lines.get(line).split(" ")[1]);
                int[] warehouseStock = Arrays.stream(lines.get(line + 1).split(" ")).mapToInt(Integer::parseInt).toArray();

                Warehouse warehouse = new Warehouse(i, x, y);
                for (int j = 0; j < warehouseStock.length; j++) {
                    warehouse.addItem(j, warehouseStock[j]);
                }

                Globals.whs.add(warehouse);

                line += 2;
            }

            int numberOfOrders = Integer.parseInt(lines.get(line));

            line += 1;

            //drones
            for (int i = 0; i < numberOfDrones; i++) {
                Globals.drones.add(i, new Drone(i, Globals.whs.get(0).coordinates.x, Globals.whs.get(0).coordinates.y));
            }

            // orders
            for (int i = 0; i < numberOfOrders; i++) {
                int x = Integer.parseInt(lines.get(line).split(" ")[0]);
                int y = Integer.parseInt(lines.get(line).split(" ")[1]);
                int numberOfItems = Integer.parseInt(lines.get(line + 1));
                int[] items = Arrays.stream(lines.get(line + 2).split(" ")).mapToInt(Integer::parseInt).toArray();
                Arrays.sort(items);

                Order order = new Order(x, y, items);

                Globals.orders.add(order);

                line += 3;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
