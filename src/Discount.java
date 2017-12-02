import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chris on 02/12/2017.
 */
public class Discount {

  public static void applyBuyOneGetOneFreeDiscount(ShoppingBasket basket) {
    HashMap<String, Integer> itemQuantities = new HashMap<>();
    double price = 0;

    // Calculate the quantity of each item that has been added to the basket
    for (Item item : basket.getItems()) {
      itemQuantities.merge(item.getName(), 1, (oldVal, newVal) -> {
        return oldVal + newVal;
      });
    }

    for (Map.Entry<String, Integer> entry : itemQuantities.entrySet()) {
      Item item = getItemByName(entry.getKey(), basket.getItems());
      double itemPrice = item.getPrice();
      int itemCount = entry.getValue();
      if (itemCount >= 2) {
        price += (itemPrice * (Math.floor(itemCount / 2))) + (itemPrice * (itemCount % 2));
      } else {
        price += itemPrice;
      }
    }

    basket.setTotalPrice(price);
  }

  public static void applyOrdersOverAmountDiscount(
    ShoppingBasket basket,
    double overAmount,
    double discountAmount
  ) {

    double price = basket.getTotalPrice();

    if (price > overAmount) {
      price *= ((100 - discountAmount) / 100);
    }

    basket.setTotalPrice(price);
  }

  public static void applyLoyaltyDiscount(ShoppingBasket basket, Person person, double discountAmount) {
    double price = basket.getTotalPrice();
    if (person.hasLoyaltyCard()) {
      price *= ((100 - discountAmount) / 100);
    }

    basket.setTotalPrice(price);
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
