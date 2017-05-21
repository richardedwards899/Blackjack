package generic_card_game;
import java.util.LinkedList;

public class Player {
  private String name;
  private LinkedList<Card> hand;
  private boolean isAggressive;
  private int twistPoint;

  public Player(String name, boolean isAggressive, int twistPoint){
    this.name = name;
    hand = new LinkedList<Card>();
    this.isAggressive = isAggressive;
    this.twistPoint = twistPoint;
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

  public int numberOfAces(){
    int aceCount = 0;
    for (Card card : hand){
      if (card.getNumber() == CardNumber.ACE){
        aceCount++;
      }
    }
    return aceCount;
  }

  public String printHand(){
    String return_string = "";
    for (Card card: hand){
      return_string += card.print();
      return_string += '\n';
    }
    return return_string;
  }

  public boolean isAggressive(){
    return isAggressive;
  }

  public int twistPoint(){
    return twistPoint;
  }

}