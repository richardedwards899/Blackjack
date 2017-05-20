package generic_card_game;
import java.util.LinkedList;

public class Deck {

  private LinkedList<Card> cards;

  public Deck(CardSuit suits, CardNumber numbers){
    cards = new LinkedList<Card>();
    createCards();
  }

  public int numberOfCards(){
    return cards.size();
  }

  private void createCards(){
    for(CardSuit suit: CardSuit.values()){
      for(CardNumber number: CardNumber.values()){
        Card card = new Card(suit, number);
        cards.add(card);
      }
    }
  }
}