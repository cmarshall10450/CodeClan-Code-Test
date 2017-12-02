import java.util.ArrayList;

/**
 * Created by chris on 02/12/2017.
 */
public class ShoppingBasket {

  ArrayList<Sellable> items = new ArrayList<>();

  public void addItem(Sellable item) {
    this.items.add(item);
  }

  public void removeItem(Sellable item) {
    this.items.remove(item);
  }

  public void clear() {
    this.items.clear();
  }

  public ArrayList<Sellable> getItems() {
    return items;
  }

}
