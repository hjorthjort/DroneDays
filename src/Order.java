import java.util.HashMap;
import java.util.Map;

/**
 * @author hjorthjort
 */
public class Order {
    Map<Integer, Integer> items = new HashMap<>();
    public int weight = 0;
    public boolean done;

    public void add(int itemNbr, int itemWeight, int quantity) {
        items.put(itemNbr, quantity);
        weight += itemWeight * quantity;
    }
}
