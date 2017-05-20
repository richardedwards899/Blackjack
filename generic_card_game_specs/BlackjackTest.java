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
    player1 = new Player("Richard");
    player2 = new Player("Corrie");
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

  @Test
  public void testScoreSingleCardInHand(){
    player1.accept(new Card(CardSuit.HEART, CardNumber.FOUR));
    assertEquals(4, blackjack.scoreHand(player1));
  }

  @Test
  public void testScoreMultipleCardsInHand(){
    player1.accept(new Card(CardSuit.HEART, CardNumber.FOUR));
    player1.accept(new Card(CardSuit.CLUB, CardNumber.JACK));

    assertEquals(14, blackjack.scoreHand(player1));
  }

  @Test
  public void testScoreMultipleCardsInHand__BUST(){
    player1.accept(new Card(CardSuit.HEART, CardNumber.FOUR));
    player1.accept(new Card(CardSuit.CLUB, CardNumber.JACK));
    player1.accept(new Card(CardSuit.CLUB, CardNumber.EIGHT));

    assertEquals(-1, blackjack.scoreHand(player1));
  }

  @Test
  public void testWhichHandIsBigger(){
    player1.accept(new Card(CardSuit.HEART, CardNumber.FOUR));
    player2.accept(new Card(CardSuit.HEART, CardNumber.FIVE));
    assertEquals(player2, blackjack.compareHands(players));
  }

  @Test
  public void testWhichHandIsBigger_multiple_cards_draw(){
    player1.accept(new Card(CardSuit.SPADE, CardNumber.FOUR));
    player1.accept(new Card(CardSuit.HEART, CardNumber.EIGHT));
    player1.accept(new Card(CardSuit.CLUB, CardNumber.EIGHT));
    player2.accept(new Card(CardSuit.HEART, CardNumber.FIVE));
    player2.accept(new Card(CardSuit.HEART, CardNumber.TEN));
    player2.accept(new Card(CardSuit.CLUB, CardNumber.FIVE));
    
    assertEquals(player1, blackjack.compareHands(players));
  }

  // }
}