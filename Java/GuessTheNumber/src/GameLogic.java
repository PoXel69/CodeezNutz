public class GameLogic {

  public boolean gameLogic(int number, int guess) {
    if (isEqual(number, guess)) {
      System.out.println("YOU DONE IT!!!\nThe Number was: " + number);
      return true;
    } else if (isBigger(number, guess)) {
      System.out.println("Close! But you Guessed Too Big!");
      return false;
    } else if (isSmaller(number, guess)) {
      System.out.println("Close! But you Guessed Too Small!");
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
