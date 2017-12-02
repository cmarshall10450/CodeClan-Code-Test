import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chris on 02/12/2017.
 */
public class TestDiscount {

  @Test
  public void canApplyBuyOneGetOneFreeDiscountToListOfItems() {
    ShoppingBasket basket = new ShoppingBasket();
    basket.addItem(new Item("Milk", 1.5));
    basket.addItem(new Item("Milk", 1.5));
    basket.addItem(new Item("Corned Beef", 1.8));
    basket.addItem(new Item("Corned Beef", 1.8));

    Discount.applyBuyOneGetOneFreeDiscount(basket);

    assertEquals(3.3, basket.getTotalPrice(), 0.01);
  }

  @Test
  public void doesNotApplyDiscountIfOrderIsUnder20() {
    ShoppingBasket basket = new ShoppingBasket();
    basket.addItem(new Item("Flash", 3.9));
    basket.addItem(new Item("Arial", 6.5));
    basket.addItem(new Item("Coffee", 4.1));
    basket.addItem(new Item("McCoys", 1.15));
    basket.addItem(new Item("Tetley Tea Bags", 1.90));

    Discount.applyOrdersOverAmountDiscount(basket, 20, 10);

    assertEquals(17.55, basket.getTotalPrice());
  }

  @Test
  public void canApplyDiscountForOrdersOver20() {
    ShoppingBasket basket = new ShoppingBasket();
    basket.addItem(new Item("Flash", 5.5));
    basket.addItem(new Item("Arial", 6.5));
    basket.addItem(new Item("Coffee", 4.1));
    basket.addItem(new Item("McCoys", 1.80));
    basket.addItem(new Item("Tetley Tea Bags", 2.5));
    basket.addItem(new Item("KitKat", 2.9));

    Discount.applyOrdersOverAmountDiscount(basket, 20, 10);

    assertEquals(20.97, basket.getTotalPrice(), 0.01);
  }

  @Test
  public void canApplyLoyaltyDiscount() {
    Person person = new Person("Chris", true);

    ShoppingBasket basket = new ShoppingBasket();
    basket.addItem(new Item("Flash", 3.9));
    basket.addItem(new Item("Arial", 6.5));
    basket.addItem(new Item("Coffee", 4.1));
    basket.addItem(new Item("McCoys", 1.1));
    basket.addItem(new Item("Tetley Tea Bags", 1.9));

    Discount.applyLoyaltyDiscount(basket, person, 2);

    assertEquals(17.15, basket.getTotalPrice(), 0.01);
  }

  @Test
  public void cannApplyAllDiscounts() {
    Person person = new Person("Chris", true);

    ShoppingBasket basket = new ShoppingBasket();
    basket.addItem(new Item("Coffee", 5));
    basket.addItem(new Item("Cheese", 5));
    basket.addItem(new Item("Arial", 6.5));
    basket.addItem(new Item("Flash", 5.5));
    basket.addItem(new Item("Coffee", 5));
    basket.addItem(new Item("Domestos", 3.9));
    basket.addItem(new Item("Cheese", 5));

    Discount.applyBuyOneGetOneFreeDiscount(basket);
    assertEquals(25.9, basket.getTotalPrice(), 0.01);

    Discount.applyOrdersOverAmountDiscount(basket, 20, 10);
    assertEquals(23.31, basket.getTotalPrice(), 0.01);

    Discount.applyLoyaltyDiscount(basket, person, 2);
    assertEquals(22.84, basket.getTotalPrice(), 0.01);
  }

}
