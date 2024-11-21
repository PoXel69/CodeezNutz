import enums.DifficultyLevel;
import enums.ErrorMessage;
import java.util.InputMismatchException;
import utils.ScannerSingleton;

public class Difficulty {
  private int maxNumberOfTries;

  public int getMaxNumberOfTries() {
    return maxNumberOfTries;
  }

  public void setMaxNumberOfTries(int maxNumberOfTries) {
    this.maxNumberOfTries = maxNumberOfTries;
  }

  public void diff() {
    try {
      System.out.println("Which difficulty you wish to play: ");
      System.out.println(DifficultyLevel.EASY);
      System.out.println(DifficultyLevel.MEDIUM);
      System.out.println(DifficultyLevel.HARD);
      System.out.print("What is your Choice: ");
      diffHandler();
    } catch (InputMismatchException ime) {
      System.err.println(ErrorMessage.INPUT_MISMATCH);
      diff();
    } catch (Exception e) {
      System.out.println(ErrorMessage.UNEXPECTED);
      diff();
    }
  }

  private void diffHandler() {
    var request = ScannerSingleton.getInstance().nextInt();
    switch (request) {
      case 1 -> easyDiff();
      case 2 -> mediumDiff();
      case 3 -> hardDiff();
      default -> {
        System.out.println("Please Enter a Number Between 1 - 3");
        diff();
      }
    }
  }

  private void easyDiff() {
    maxNumberOfTries = 20;
  }

  private void mediumDiff() {
    maxNumberOfTries = 10;
  }

  private void hardDiff() {
    maxNumberOfTries = 5;
  }
}
