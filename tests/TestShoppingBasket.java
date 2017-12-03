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

    assertEquals(8, basket.getTotalPrice(), 0.01);
  }

  @Test
  public void canSetTotalPrice() {
    basket.setTotalPrice(10);
    assertEquals(10, basket.getTotalPrice(), 0.01);
  }

  @Test
  public void canGetItems() {
    Item item = new Item("Eggs", 2);
    basket.addItem(item);

    assertEquals(item, basket.getItems().get(0));
  }

  @Test
  public void canGetItemByName() {
    Item expected = new Item("Eggs", 2);
    basket.addItem(expected);

    Item actual = basket.getItemByName("Eggs");
    assertEquals(expected.getName(), actual.getName());
  }

  @Test
  public void basketCanApplyAllDiscountsToItself() {
    Person person = new Person("Chris", true);

    basket.addItem(new Item("Coffee", 5));
    basket.addItem(new Item("Cheese", 5));
    basket.addItem(new Item("Arial", 6.5));
    basket.addItem(new Item("Flash", 5.5));
    basket.addItem(new Item("Coffee", 5));
    basket.addItem(new Item("Domestos", 3.9));
    basket.addItem(new Item("Cheese", 5));

    basket.applyDiscounts(person);
    assertEquals(22.84, basket.getTotalPrice(), 0.01);
  }

}
