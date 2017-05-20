package generic_card_game;
import java.util.LinkedList;

public abstract class RulesEngine{

  private Dealer dealer;
  private Deck deck;
  private LinkedList<Player> players; 

  public RulesEngine(Dealer dealer, Deck deck, LinkedList<Player> players){
    this.dealer = dealer;
    this.deck = deck;
    this.players = players;
  }

  public abstract void start();
  public abstract void distributeCards();
  public abstract boolean checkForWinner();
  public abstract int value(Card card);
  public abstract int scoreHand(Player player);
  public abstract Player compareHands(LinkedList<Player> players);
  public abstract boolean playerWins(Player player, Dealer dealer);
}