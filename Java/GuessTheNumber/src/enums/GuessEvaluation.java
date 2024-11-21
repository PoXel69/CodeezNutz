package enums;

public enum GuessEvaluation {
  RIGHT_GUESS("YOU DONE IT!!!\nThe Number was: "),
  HIGH_GUESS("Close! But you Guessed Too Big!"),
  LOW_GUESS("Close! But you Guessed Too Small!");
  private final String label;

  GuessEvaluation(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }
}
