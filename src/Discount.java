import java.util.HashMap;
import java.util.Map;

/**
 * Created by chris on 02/12/2017.
 */
public class Discount {

  /**
   * If an item appears more than once in the basket then it is eligible for
   * the 'Buy One Get One Free' discount. The discount applies to an item in
   * pairs of two e.g the second and fourth item is free but the third is paid for
   *
   * @param basket The shopping basket which the discount is to be applied to
   */
  public static void applyBuyOneGetOneFreeDiscount(ShoppingBasket basket) {
    HashMap<String, Integer> itemQuantities = new HashMap<>();
    double price = 0;

    // Calculate the quantity of each item that has been added to the basket
    for (Item item : basket.getItems()) {
      itemQuantities.merge(item.getName(), 1, (oldVal, newVal) -> oldVal + newVal);
    }

    for (Map.Entry<String, Integer> entry : itemQuantities.entrySet()) {
      Item item = basket.getItemByName(entry.getKey());
      double itemPrice = item.getPrice();
      int itemCount = entry.getValue();
      if (itemCount >= 2) {
        /* If the item appears more than once in the basket then calculate the price
           for each pair and add on the remainder
        */
        price += (itemPrice * (Math.floor(itemCount / 2))) + (itemPrice * (itemCount % 2));
      } else {
        price += itemPrice;
      }
    }

    basket.setTotalPrice(price);
  }

  /**
   * Orders over a certain total are eligible for a discount. This can applied
   * after or before other discounts.
   *
   * @param basket         The shopping basket which the discount is to be applied to
   * @param overAmount     The amount that the total needs to be over before the deal applies
   * @param discountAmount The percentage discount to be applied
   */
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

  /**
   * Customers who have a loyalty card are eligible for a certain discount rate
   * on purchases. This discount is applied after all other discounts.
   *
   * @param basket         The shopping basket which the discount is to be applied to
   * @param person         The person who is in control of the shopping basket
   * @param discountAmount The percentage discount to be applied
   */
  public static void applyLoyaltyDiscount(ShoppingBasket basket, Person person, double discountAmount) {
    double price = basket.getTotalPrice();
    if (person.hasLoyaltyCard()) {
      price *= ((100 - discountAmount) / 100);
    }

    basket.setTotalPrice(price);
  }
}
