package drones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

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
            int[] weights = Arrays.stream(lines.get(line + 1).split(" ")).mapToInt(Integer::parseInt).toArray();

            line += 2;

            int numberOfWarehouses = Integer.parseInt(lines.get(line));

            line += 1;

            for (int i = 0; i < numberOfWarehouses; i++) {
                int x = Integer.parseInt(lines.get(line).split(" ")[0]);
                int y = Integer.parseInt(lines.get(line).split(" ")[1]);
                int[] warehouseStock = Arrays.stream(lines.get(line + 1).split(" ")).mapToInt(Integer::parseInt).toArray();

                line += 2;
            }

            int numberOfOrders = Integer.parseInt(lines.get(line));

            line += 1;

            for (int i = 0; i < numberOfOrders; i++) {
                int x = Integer.parseInt(lines.get(line).split(" ")[0]);
                int y = Integer.parseInt(lines.get(line).split(" ")[1]);
                int numberOfItems = Integer.parseInt(lines.get(line + 1));
                int[] items = Arrays.stream(lines.get(line + 2).split(" ")).mapToInt(Integer::parseInt).toArray();

                line += 3;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
