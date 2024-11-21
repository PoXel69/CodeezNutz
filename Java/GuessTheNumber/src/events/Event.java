package events;

public interface Event {
  default boolean event() {
    return false;
  }

  default boolean event(int number, int guess) {
    return false;
  }
}
