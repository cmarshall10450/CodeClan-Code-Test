import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chris on 02/12/2017.
 */
public class TestDiscount {

  @Test
  public void canApplyBuyOneGetOneFreeDiscountToListOfItems() {
    ArrayList<Item> items = new ArrayList<>();
    items.add(new Item("Eggs", 2));
    items.add(new Item("Bread", 3));
    items.add(new Item("Eggs", 2));

    assertEquals(5, Discount.applyBuyOneGetOneFreeDiscount(items, 0), 0.01);
  }

  @Test
  public void canApplyDiscountForOrdersOver20() {
    ArrayList<Item> items = new ArrayList<>();
    items.add(new Item("Eggs", 10));
    items.add(new Item("Bread", 10));
    items.add(new Item("Eggs", 10));

    assertEquals(27, Discount.applyOrdersOverAmountDiscount(20, 10, items), 0.01);
  }

}
