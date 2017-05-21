import static org.junit.Assert.*;
import org.junit.*;
import generic_card_game.*;
import java.util.LinkedList;
import org.mockito.*;
import static org.mockito.Mockito.*;

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
    player1 = new Player("Nigel");
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

  @Test
  public void testPlayerBeatsDealer(){
    player1.accept(new Card(CardSuit.SPADE, CardNumber.SIX));
    dealer.accept(new Card(CardSuit.HEART, CardNumber.FIVE));
    assertEquals(true, blackjack.playerWins(player1, dealer));
  }

  @Test
  public void testCanDistributeTwoCards(){
    blackjack.dealCards();
    assertEquals(2, player1.numberOfCards());
    assertEquals(2, player2.numberOfCards());
    assertEquals(2, dealer.numberOfCards());
  }

  @Test 
  public void canScoreNonAceCards(){
    Card card1 = new Card(CardSuit.CLUB, CardNumber.ACE);
    Card card2 = new Card(CardSuit.HEART, CardNumber.ACE);
    Card card3 = new Card(CardSuit.CLUB, CardNumber.SIX);
    Card card4 = new Card(CardSuit.CLUB, CardNumber.TWO);
    Card card5 = new Card(CardSuit.CLUB, CardNumber.FOUR);
    player1.accept(card1);
    player1.accept(card2);
    player1.accept(card3);
    player1.accept(card4);
    player1.accept(card5);
    assertEquals(12, blackjack.pointsOfNonAceCards(player1));
  }

  @Test
  public void canRunBlackjack(){

    //artificially specifies the order of the cards that will be dealt to Player1, Player 2 and the dealer.
    Card card1 = new Card(CardSuit.HEART, CardNumber.TEN);
    Card card2 = new Card(CardSuit.CLUB, CardNumber.SIX);
    Card card3 = new Card(CardSuit.DIAMOND, CardNumber.FIVE);
    Card card4 = new Card(CardSuit.SPADE, CardNumber.SEVEN);
    Card card5 = new Card(CardSuit.HEART, CardNumber.NINE);
    Card card6 = new Card(CardSuit.SPADE, CardNumber.SIX);

    Deck mock_deck = mock(Deck.class);
    blackjack = new Blackjack(dealer, mock_deck, players);

    when(mock_deck.getCard()).thenReturn(card1).thenReturn(card2).thenReturn(card3).thenReturn(card4).thenReturn(card5).thenReturn(card6);

    blackjack.run();

    assertEquals(2, player1.hand().size());
    assertEquals(2, player2.hand().size());
    assertEquals(2, dealer.hand().size());

    assertEquals("HEART TEN"+'\n'+"CLUB SIX"+'\n', player1.printHand());
    assertEquals("DIAMOND FIVE"+'\n'+"SPADE SEVEN"+'\n', player2.printHand());
    assertEquals("HEART NINE"+'\n'+"SPADE SIX"+'\n', dealer.printHand());



    // assertEquals(true, blackjack.playerWins(player1, dealer));
    // assertEquals(false, blackjack.playerWins(player2, dealer));
    // assertEquals(player1, blackjack.compareHands(players));



  }
}