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

            System.out.println(Arrays.toString(lines.get(0).split(" ")));

            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
