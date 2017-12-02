import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chris on 02/12/2017.
 */
public class Discount {

  public static double applyBuyOneGetOneFreeDiscount(ArrayList<Item> items, double price) {
    HashMap<String, Integer> itemQuantities = new HashMap<>();

    // Calculate the quantity of each item that has been added to the basket
    for (Item item : items) {
      itemQuantities.merge(item.getName(), 1, (oldVal, newVal) -> {
        return oldVal + newVal;
      });
    }

    for (Map.Entry<String, Integer> entry : itemQuantities.entrySet()) {
      Item item = getItemByName(entry.getKey(), items);
      double itemPrice = item.getPrice();
      int itemCount = entry.getValue();
      if (itemCount >= 2) {
        price += (itemPrice * (Math.floor(itemCount / 2))) + (itemPrice * (itemCount % 2));
      } else {
        price += itemPrice;
      }
    }

    return price;
  }

  public static double applyOrdersOverAmountDiscount(
    double overAmount,
    double discountAmount,
    ArrayList<Item> items,
    double price
  ) {
    double total = 0;
    for (Item item : items) {
      total += item.getPrice();
    }

    if (total > overAmount) {
      price *= ((100 - discountAmount) / 100);
    }

    return price;
  }

  private static Item getItemByName(String name, ArrayList<Item> items) {
    for (Item item : items) {
      if (item.getName().equals(name)) {
        return item;
      }
    }

    return null;
  }
}
