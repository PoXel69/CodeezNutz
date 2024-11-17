package NumberGuess;

import java.util.InputMismatchException;
import java.util.Scanner;

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
      System.out.println("1. Easy | Pussy");
      System.out.println("2. Medium | Ok");
      System.out.println("3. Hard | Ma Boi");
      System.out.print("What is your Choice: ");
      diffHandler();
    } catch (InputMismatchException ime) {
      System.out.println("Please Enter Integers");
      diff();
    } catch (Exception e) {
      System.out.println("Something went wrong, Please try again!");
      diff();
    }
  }

  private void diffHandler() {
    var request = new Scanner(System.in).nextInt();
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
