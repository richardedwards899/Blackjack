import static org.junit.Assert.*;
import org.junit.*;
import generic_card_game.*;

public class CardTest {

  //test variables here
  private Card card;   

  @Before
  public void before(){
    card = new Card(CardSuit.HEART, CardNumber.TWO);
  }

  @Test
  public void canCreateCard(){
    assertEquals(CardSuit.HEART, card.getSuit());
    assertEquals(CardNumber.TWO, card.getNumber());
  }
}