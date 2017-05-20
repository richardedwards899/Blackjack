import static org.junit.Assert.*;
import org.junit.*;
import generic_card_game.*;

public class PlayerTest {

  //test variables here
  private Player player;   

  @Before
  public void before(){
    player = new Player("Stevie");
  }

  @Test
  public void canCreatePlayer(){
    assertEquals("Stevie", player.getName());
  }

  @Test
  public void canAddCardToHand(){
    Card card = new Card(CardSuit.CLUB, CardNumber.ACE);
    player.accept(card);
    assertEquals(1, player.numberOfCards());
  }
}