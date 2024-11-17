package NumberGuess;

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
    gameLoop(start, end);
  }

  public GuessNumber(int end) {
    this.START = 0;
    this.END = end;
    gameLoop(START, end);
  }

  public GuessNumber() {
    gameLoop(0, 100);
  }

  public void gameLoop(int start, int end) {
    Difficulty diff = new Difficulty();
    boolean hasGuessed = false;
    var gl = new GameLogic();
    var guess = new Scanner(System.in);
    while (wantToPlay) {
      diff.diff();
      var number = randomNumberGenerator(start, end);
      hasGuessed = false;
      while (!hasGuessed && diff.getMaxNumberOfTries() != 0) {
        try {
          System.out.println("Number of Tries left: " + diff.getMaxNumberOfTries());
          System.out.print("Guess a Number: ");
          hasGuessed = gl.gameLogic(number, guess.nextInt());
        } catch (InputMismatchException ime) {
          System.out.println("\nPlease Enter an Integer: ");
          guess.nextLine();
        }
      }
      diff.setMaxNumberOfTries(diff.getMaxNumberOfTries() - 1);
      if (gameOver()) break;
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

  private int randomNumberGenerator(int start, int end) {
    return new Random().nextInt(end - start + 1) + start;
  }
}
