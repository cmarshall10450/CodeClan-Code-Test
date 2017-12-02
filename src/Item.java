/**
 * Created by chris on 02/12/2017.
 */
public class Item implements Sellable {

  String name;
  double price;

  public Item(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }
}
