package generic_card_game;
import java.util.LinkedList;
import java.util.Random;

public class Deck {

  private LinkedList<Card> cards;

  public Deck(CardSuit suits, CardNumber numbers){
    cards = new LinkedList<Card>();
    createCards();
  }

  public int numberOfCards(){
    return cards.size();
  }

  public Card getCard(){
    if (cards.size() > 0) {
      int random_card_position = randomNumber(cards.size()); 
      return cards.remove(random_card_position);
    }
    else return null;
  }

  public void print(){
    for(int i=0; i<numberOfCards(); i++){
      System.out.println(cards.get(i).getSuit()+" "+cards.get(i).getNumber());
    }
  }

  private void createCards(){
    for(CardSuit suit: CardSuit.values()){
      for(CardNumber number: CardNumber.values()){
        Card card = new Card(suit, number);
        cards.add(card);
      }
    }
  }

  private int randomNumber(int max){
    Random rand = new Random();
    int result = rand.nextInt(max);
    return result;
  }
}