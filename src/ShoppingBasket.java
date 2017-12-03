import java.util.ArrayList;

/**
 * Created by chris on 02/12/2017.
 */
public class ShoppingBasket {

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

  public Item getItemByName(String name) {
    for (Item item : items) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    return null;
  }

  public void applyDiscounts(Person person) {
    Discount.applyBuyOneGetOneFreeDiscount(this);
    Discount.applyOrdersOverAmountDiscount(this, 20, 10);
    Discount.applyLoyaltyDiscount(this, person, 2);
  }
}
