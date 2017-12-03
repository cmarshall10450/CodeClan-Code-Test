import java.util.ArrayList;

/**
 * Created by chris on 03/12/2017.
 */
public interface Discountable {

  ArrayList<Item> getItems();

  Item getItemByName(String name);

  double getTotalPrice();

  void setTotalPrice(double price);


}
