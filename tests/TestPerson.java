import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chris on 02/12/2017.
 */
public class TestPerson {

  Person person;

  @Before
  public void setup() {
    person = new Person("Chris");
  }

  @Test
  public void hasName() {
    assertEquals("Chris", person.getName());
  }

  @Test
  public void doesNotHaveLoyaltyCardToStartWith() {
    assertEquals(false, person.hasLoyaltyCard());
  }

  @Test
  public void canObtainALoyaltyCard() {
    person.obtainLoyaltyCard();
    assertEquals(true, person.hasLoyaltyCard());
  }

}
