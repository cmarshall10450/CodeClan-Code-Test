import java.util.ArrayList;

/**
 * Created by chris on 02/12/2017.
 */
public class ShoppingBasket {

  ArrayList<Item> items = new ArrayList<>();

  public void addItem(Item item) {
    this.items.add(item);
  }

  public void removeItem(Item item) {
    this.items.remove(item);
  }

  public void clear() {
    this.items.clear();
  }

  public double calculateTotalPrice() {
    double price = 0;
    price = Discount.applyBuyOneGetOneFreeDiscount(items, price);
    price = Discount.applyOrdersOverAmountDiscount(items, 20, 10, price);
    return price;
  }

  public ArrayList<Item> getItems() {
    return items;
  }
}
