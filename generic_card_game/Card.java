package generic_card_game;
import java.util.LinkedList;

public class Card {

  private CardSuit suit;
  private CardNumber number;

  public Card(CardSuit suit, CardNumber number) {
    this.suit = suit;
    this.number = number;
  }

  public CardSuit getSuit(){
    return suit;
  }

  public CardNumber getNumber(){
    return number;
  }

  public String print(){
    return suit+" "+number;
  }
}