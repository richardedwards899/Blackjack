package generic_card_game;
import java.util.LinkedList;

public abstract class RulesEngine{

  protected Dealer dealer;
  protected Deck deck;
  protected LinkedList<Player> players; 

  public RulesEngine(Dealer dealer, Deck deck, LinkedList<Player> players){
    this.dealer = dealer;
    this.deck = deck;
    this.players = players;
  }

  public abstract void run();
  public abstract void dealCards();
  public abstract int value(Card card);
  public abstract int[] scoreHand(Player player);
  public abstract boolean playerWins(Player player, Dealer dealer);
}