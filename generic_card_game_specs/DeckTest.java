import static org.junit.Assert.*;
import org.junit.*;
import generic_card_game.*;
import java.util.LinkedList;

public class DeckTest {

  //test variables here
  private Deck deck;   
  private CardSuit suits;
  private CardNumber numbers;

  @Before
  public void before(){
    deck = new Deck( suits, numbers );
  }

  @Test
  public void canCreateDeck(){
    assertEquals(52, deck.numberOfCards());
  }

  @Test
  public void getGetCard(){
    Card card = deck.getCard();
    assertEquals(51, deck.numberOfCards());
  }
}