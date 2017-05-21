import generic_card_game.*;
import java.util.LinkedList;

public class Runner{

  static Dealer dealer;
  static CardSuit suits;
  static CardNumber numbers;
  static Deck deck; 
  static Blackjack blackjack;
  static Player player1;
  static Player player2; 
  static LinkedList<Player> players;

  public static void main(String[] args){
    player1 = new Player("Raymond", true, 18);
    player2 = new Player("Charlie", false, 16);
    dealer = new Dealer("Dealer", false, 17);
    deck = new Deck(suits, numbers);
    players = new LinkedList<Player>();
    players.add(player1);
    players.add(player2);
    blackjack = new Blackjack(dealer, deck, players);
    blackjack.run();
  }

}