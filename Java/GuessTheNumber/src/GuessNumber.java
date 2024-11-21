import enums.ErrorMessage;
import events.NumberGuessEvent;
import events.QuitEvent;
import java.util.InputMismatchException;
import utils.RandomNumberGenerator;
import utils.ScannerSingleton;

public class GuessNumber {
  private final int start;
  private final int end;

  public GuessNumber(int start, int end) {
    this.start = start;
    this.end = end;
    gameLoop();
  }

  public GuessNumber(int end) {
    this.start = 0;
    this.end = end;
    gameLoop();
  }

  public void gameLoop() {
    var difficulty = new Difficulty();
    var scanner = ScannerSingleton.getInstance();
    do {
      difficulty.diff();
      var number = new RandomNumberGenerator().randomNumberGenerator(start, end);
      boolean hasGuessed = false;
      while (!hasGuessed) {
        var numberOfTries = difficulty.getMaxNumberOfTries();
        if (numberOfTries == 0) break;
        try {
          System.out.println("Number of Tries left: " + numberOfTries);
          System.out.print("Guess a Number: ");
          hasGuessed = new NumberGuessEvent().event(number, scanner.nextInt());
        } catch (InputMismatchException ime) {
          System.out.println(ErrorMessage.INPUT_MISMATCH);
          scanner.nextLine();
        }
        difficulty.setMaxNumberOfTries(numberOfTries - 1);
      }
    } while (!new QuitEvent().event());
  }
}
