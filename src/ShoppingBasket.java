import java.util.ArrayList;

/**
 * Created by chris on 02/12/2017.
 */
public class ShoppingBasket implements Discountable {

  ArrayList<Item> items;
  double totalPrice;

  public ShoppingBasket() {
    this.items = new ArrayList<>();
    this.totalPrice = 0;
  }

  public void addItem(Item item) {
    this.items.add(item);
    this.totalPrice += item.getPrice();
  }

  public void removeItem(Item item) {
    this.items.remove(item);
    this.totalPrice -= item.getPrice();
  }

  public void clear() {
    this.items.clear();
    this.totalPrice = 0;
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * Searches for an item in the baskets list by the name of the item
   *
   * @param name
   * @return Returns an item if it is found, otherwise returns null
   */
  public Item getItemByName(String name) {
    for (Item item : items) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    return null;
  }

  /**
   * Disccounts are applied in a particular order and the new price is
   * only calculated after previous discounts have been applied.
   *
   * @param person The person who is applying the loyalty discount
   */
  public void applyDiscounts(Person person) {
    Discount.applyBuyOneGetOneFreeDiscount(this);
    Discount.applyOrdersOverAmountDiscount(this, 20, 10);
    Discount.applyLoyaltyDiscount(this, person, 2);
  }
}
