package events;

import utils.ScannerSingleton;

public class GameOverEvent implements Event {

  @Override
  public boolean event() {
    System.out.println("Would you like to Play Again?");
    System.out.println("1. To play again");
    System.out.println("2. Quit");
    System.out.println("Enter you Choice: ");
    var pick = ScannerSingleton.getInstance().nextInt();
    return pick != 1;
  }
}
