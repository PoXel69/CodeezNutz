package enums;

public enum DifficultyLevel {
  EASY("1. Easy | Pussy"),
  MEDIUM("2. Medium | Ok"),
  HARD("3. Hard | Ma Boi");
  private final String label;

  DifficultyLevel(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }
}
