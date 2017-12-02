import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chris on 02/12/2017.
 */
public class TestShoppingBasket {

  ShoppingBasket basket;

  @Before
  public void setup() {
    basket = new ShoppingBasket();
  }

  @Test
  public void canAddItem() {
    Item item = new Item("Eggs", 1.75);
    basket.addItem(item);

    assertEquals(1, basket.getItems().size());
  }

  @Test
  public void canRemoveItem() {
    Item item = new Item("Eggs", 1.75);
    basket.addItem(item);
    basket.removeItem(item);

    assertEquals(0, basket.getItems().size());
  }

  @Test
  public void canClearBasket() {
    Item item = new Item("Eggs", 1.75);
    basket.addItem(item);
    basket.clear();

    assertEquals(0, basket.getItems().size());
  }

  @Test
  public void canGetTotalPrice() {
    basket.addItem(new Item("Eggs", 2));
    basket.addItem(new Item("Bread", 4));
    basket.addItem(new Item("Eggs", 2));

    assertEquals(6, basket.getTotalPrice(), 0.01);
  }

}
