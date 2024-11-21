package events;

import enums.GuessEvaluation;

public class NumberGuessEvent implements Event {

  @Override
  public boolean event(int number, int guess) {
    if (isEqual(number, guess)) {
      System.out.println(GuessEvaluation.RIGHT_GUESS + "" + number);
      return true;
    } else if (isBigger(number, guess)) {
      System.out.println(GuessEvaluation.HIGH_GUESS);
      return false;
    } else if (isSmaller(number, guess)) {
      System.out.println(GuessEvaluation.LOW_GUESS);
      return false;
    }
    return false;
  }

  private boolean isEqual(int number, int guess) {
    return number == guess;
  }

  private boolean isBigger(int number, int guess) {
    return number < guess;
  }

  private boolean isSmaller(int number, int guess) {
    return number > guess;
  }
}
