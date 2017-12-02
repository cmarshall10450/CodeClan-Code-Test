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
}
