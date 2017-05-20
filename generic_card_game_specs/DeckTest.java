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

  @Test
  public void getGetAllCards(){
    int cards_in_deck = deck.numberOfCards();
    for(int i=0; i<cards_in_deck; i++){
      Card card = deck.getCard();
    }
  assertEquals(0, deck.numberOfCards());
  }

  @Test
  public void cantGetMoreCardsThanExist(){
    int cards_in_deck = deck.numberOfCards();
    Card card = new Card(CardSuit.CLUB, CardNumber.TWO);

    for(int i=0; i< (cards_in_deck + 1); i++){
      card = deck.getCard();
    }
  assertEquals(0, deck.numberOfCards());
  assertNull(null, card);   
  }
}