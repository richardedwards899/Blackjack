import static org.junit.Assert.*;
import org.junit.*;
import generic_card_game.*;
import java.util.LinkedList;

public class BlackjackTest {

  //test variables here
  Dealer dealer;
  CardSuit suits;
  CardNumber numbers;
  Deck deck; 
  Blackjack blackjack;
  Player player1;
  Player player2; 
  LinkedList<Player> players;

  @Before
  public void before(){
    dealer = new Dealer("Dealer");
    deck = new Deck(suits, numbers);
    players = new LinkedList<Player>();
    players.add(player1);
    players.add(player2);
    blackjack = new Blackjack(dealer, deck, players);
  }

  @Test
  public void testValueOfCard(){
    Card card = new Card(CardSuit.SPADE, CardNumber.THREE);
    assertEquals(3, blackjack.value(card));
  }

  @Test
  public void testValueOfFaceCard(){
    Card card = new Card(CardSuit.SPADE, CardNumber.QUEEN);
    assertEquals(10, blackjack.value(card));
  }

  @Test
  public void testValueOfAce(){
    Card card = new Card(CardSuit.SPADE, CardNumber.ACE);
    assertEquals(1, blackjack.value(card));
  }

   
  // }
}