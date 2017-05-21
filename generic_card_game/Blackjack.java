package generic_card_game;
import java.util.LinkedList;

public class Blackjack extends RulesEngine {

  public static int bust = 21;

  public Blackjack(Dealer dealer, Deck deck, LinkedList<Player> players){
    super(dealer, deck, players);
  }

  public void run(){
    dealCards();
    askAllPlayersIfTheyWannaTwist();
    dealerFlops();
    declareResults();
  }

  private void declareResults(){
    for (Player player: players){
      if (playerWins(player, dealer)){
        System.out.println(player.getName()+" wins with a score of (aces low) "+scoreHand(player)[0]+" and (aces high) "+scoreHand(player)[1]);
      }
      else {
        System.out.println(player.getName()+" loses with a score of (aces low) "+scoreHand(player)[0]+" and (aces high) "+scoreHand(player)[1]);
      }
      System.out.println(dealer.getName()+ " has a score of (aces low) "+scoreHand(dealer)[0]+" and (aces high) "+scoreHand(dealer)[1]);
    }
  }

  private void dealerFlops(){
    dealer.dealCard(deck, dealer);
  }

  private void askAllPlayersIfTheyWannaTwist(){
    for (Player player: players){
      while (twist(player)){
        dealer.dealCard(deck, player);
      }
    }
  }

  private boolean twist(Player player){
    int[] scores = scoreHand(player);

    if (bust(player)){
      return false;
    }
    if (player.isAggressive()){
      return (scores[0] < player.twistPoint());
    }
    else {
      return (scores[0] < player.twistPoint() && scores[1] < player.twistPoint());
    } 
  }

  private boolean bust(Player player){
    int[] scores = scoreHand(player);
    return scores[0] == -1 && scores[1] == -1;
  }
  
  public void dealCards(){
    for (Player player: players){
      dealer.dealCard(deck, player);
      dealer.dealCard(deck, player);
    }
    dealer.dealCard(deck, dealer);
    dealer.dealCard(deck, dealer);
  }

  public boolean playerWins(Player player, Dealer dealer){
    int[] scores_of_player = scoreHand(player);
    int[] scores_of_dealer = scoreHand(dealer);
    boolean win = false;
    
    if (scores_of_player[0] > scores_of_dealer[0] && scores_of_player[0] > scores_of_dealer[1]){
      win = true;
    }
    if (scores_of_player[1] > scores_of_dealer[0] && scores_of_player[1] > scores_of_dealer[1]){
      win = true;
    }
    return win;
  }

  public int[] scoreHand(Player player){
    int aces = player.numberOfAces();
    int lowAceScore = lowAceScore(aces);
    int highAceScore = highAceScore(aces);
    int nonAcePoints = pointsOfNonAceCards(player);

    int scores[] = new int[2];
    int low_total = lowAceScore + nonAcePoints;
    int high_total = highAceScore + nonAcePoints;

    if (low_total > bust){
      scores[0] = -1;
    }
    else { scores[0] = low_total; }

    if (high_total > bust) {
      scores[1] = -1;
    }
    else { scores[1] = high_total; }

    return scores;
  }

  private int lowAceScore(int numberOfAces){
    return numberOfAces;
  }

  private int highAceScore(int numberOfAces){
    if (numberOfAces > 0){
      return 11 + (numberOfAces-1);
    }
    else return 0;
  }

  public int pointsOfNonAceCards(Player player){
    int points = 0;
    for (Card card: player.hand()){
      if (card.getNumber() != CardNumber.ACE){
        points += value(card);
      }
    }
    return points;
  }

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