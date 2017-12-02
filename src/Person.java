/**
 * Created by chris on 02/12/2017.
 */
public class Person {

  private String name;
  private boolean hasLoyaltyCard;

  public Person(String name) {
    this.name = name;
    this.hasLoyaltyCard = false;
  }

  public Person(String name, boolean hasLoyaltyCard) {
    this.name = name;
    this.hasLoyaltyCard = hasLoyaltyCard;
  }

  public String getName() {
    return name;
  }

  public boolean hasLoyaltyCard() {
    return hasLoyaltyCard;
  }

  public void obtainLoyaltyCard() {
    this.hasLoyaltyCard = true;
  }
}
