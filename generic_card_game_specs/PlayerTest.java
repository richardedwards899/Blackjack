import static org.junit.Assert.*;
import org.junit.*;
import generic_card_game.*;
import java.util.LinkedList;

public class PlayerTest {

  //test variables here
  private Player player;   

  @Before
  public void before(){
    player = new Player("Stevie");
  }

  @Test
  public void canCreatePlayer(){
    assertEquals("Stevie", player.getName());
  }

  @Test
  public void canAddCardToHand(){
    Card card = new Card(CardSuit.CLUB, CardNumber.ACE);
    player.accept(card);
    assertEquals(1, player.numberOfCards());
  }

  @Test
  public void canHoldMultipleCardsInHand(){
    Card card1 = new Card(CardSuit.CLUB, CardNumber.ACE);
    Card card2 = new Card(CardSuit.CLUB, CardNumber.ACE);
    player.accept(card1);
    player.accept(card2);
    assertEquals(2, player.numberOfCards());
  }

  @Test
  public void canReturnHand(){
   Card card1 = new Card(CardSuit.CLUB, CardNumber.ACE);
   Card card2 = new Card(CardSuit.CLUB, CardNumber.ACE);
   player.accept(card1);
   player.accept(card2);
   LinkedList<Card> expected = new LinkedList<Card>();
   expected.add(card1);
   expected.add(card2);
   assertEquals(expected, player.hand());
  }
}