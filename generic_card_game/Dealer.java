package generic_card_game;

public class Dealer extends Player {

  public Dealer(String name, boolean isAggressive, int twistPoint){
    super(name, isAggressive, twistPoint);
  }

  public void dealCard(Deck deck, Player player){
    Card card = deck.getCard();
    System.out.println("Dealer deals "+card.print()+" to "+player.getName());
    player.accept(card);
  }

}