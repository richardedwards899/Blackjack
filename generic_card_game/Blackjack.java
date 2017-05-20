package generic_card_game;
import java.util.LinkedList;

public class Blackjack extends RulesEngine {

  public Blackjack(Dealer dealer, Deck deck, LinkedList<Player> players){
    super(dealer, deck, players);
  }

  //UNTESTED!!!
  public void start(){

  }
  public void distributeCards(){

  }
  public boolean checkForWinner(){
    return false;
  }
  
 
  public Player compareHands(LinkedList<Player> players){
    return new Player("Bob");
  }
  public Player compareHands(Player player, Dealer dealer){
    return new Player("Rupe");
  }
  //Testing............

  public int scoreHand(Player player){
    return 0;
  }

  //TESTED!
  public int value(Card card){
    int return_value = 0;
    switch (card.getNumber()){
      case ACE:
        return_value = 1;
        break;
      case TWO:
        return_value = 2;
        break;
      case THREE:
        return_value = 3;
        break;
      case FOUR:
        return_value = 4;
        break;
      case FIVE:
        return_value = 5;
        break;
      case SIX:
        return_value = 6;
        break;
      case SEVEN:
        return_value = 7;
        break;      
      case EIGHT:
        return_value = 8;
        break;
      case NINE:
        return_value = 9;
        break;
      case TEN:
        return_value = 10;
        break;
      case JACK:
        return_value = 10;
        break;
      case QUEEN:
        return_value = 10;
        break;
      case KING:
        return_value = 10;
        break;
    }
    return return_value;
  }



}