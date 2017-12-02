import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chris on 02/12/2017.
 */
public class TestItem {

  Item item;

  @Before
  public void setup() {
    item = new Item("Eggs", 1.75);
  }

  @Test
  public void ItemHasName() {
    assertEquals("Eggs", item.getName());
  }

  @Test
  public void ItemHasPrice() {
    assertEquals(1.75, item.getPrice(), 0.01);
  }

}
