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
  public void CanAddItem() {
    Item item = new Item("Eggs", 1.75);
    basket.addItem(item);

    assertEquals(1, basket.getItems().size());
  }

}
