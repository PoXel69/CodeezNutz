package enums;

public enum ErrorMessage {
  INPUT_MISMATCH("Please Enter Integers"),
  UNEXPECTED("Something went wrong, Please try again!"),
  GOODBUY_MESSAGE("GG, Have a great time!");
  private final String label;

  ErrorMessage(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }
}
