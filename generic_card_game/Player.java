package generic_card_game;
import java.util.LinkedList;

public class Player {
  private String name;
  private LinkedList<Card> hand;

  public Player(String name){
    this.name = name;
    hand = new LinkedList<Card>();
  }

  public String getName(){
    return name;
  }

  public void accept(Card card){
    hand.add(card);
  }

  public int numberOfCards(){
    return hand.size();
  }

  public LinkedList<Card> hand(){
    return hand;
  }

}