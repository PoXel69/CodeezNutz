import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
  boolean wantToPlay = true;
  private int START;
  private int END;

  public GuessNumber(int start, int end) {
    this.START = start;
    this.END = end;
    gameLoop();
  }

  public GuessNumber(int end) {
    this.START = 0;
    this.END = end;
    gameLoop();
  }

  public GuessNumber() {
    gameLoop();
  }

  public void gameLoop() {
    var diff = new Difficulty();
    boolean hasGuessed;
    var guess = new Scanner(System.in);
    while (wantToPlay) {
      diff.diff();
      var number = randomNumberGenerator();
      hasGuessed = false;
      while (!hasGuessed && diff.getMaxNumberOfTries() != 0) {
        try {
          System.out.println("Number of Tries left: " + diff.getMaxNumberOfTries());
          System.out.print("Guess a Number: ");
          hasGuessed = new GameLogic().gameLogic(number, guess.nextInt());
        } catch (InputMismatchException ime) {
          System.out.println("\nPlease Enter an Integer: ");
          guess.nextLine();
        }
        diff.setMaxNumberOfTries(diff.getMaxNumberOfTries() - 1);
      }
      if (gameOver()) {
        System.err.println(("GG, Have a great time!"));
        break;
      }
    }
  }

  boolean gameOver() {
    System.out.println("Would you like to Play Again?");
    System.out.println("1. To play again");
    System.out.println("2. Quit");
    System.out.println("Enter you Choice: ");
    var pick = new Scanner(System.in).nextInt();
    return pick != 1;
  }

  private int randomNumberGenerator() {
    return new Random().nextInt(END - START + 1) + START;
  }
}
