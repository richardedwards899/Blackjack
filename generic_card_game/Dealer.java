package generic_card_game;

public class Dealer extends Player {

  public Dealer(String name){
    super(name);
  }

  public void dealCard(Deck deck, Player player){
    player.accept( deck.getCard() );
  }

}