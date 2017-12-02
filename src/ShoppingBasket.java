import java.util.ArrayList;

/**
 * Created by chris on 02/12/2017.
 */
public class ShoppingBasket {

  ArrayList<Sellable> items = new ArrayList<>();

  public void addItem(Sellable item) {
    this.items.add(item);
  }

  public ArrayList<Sellable> getItems() {
    return items;
  }
}
