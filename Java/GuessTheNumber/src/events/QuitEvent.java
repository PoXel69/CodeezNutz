package events;

import enums.ErrorMessage;

public class QuitEvent implements Event {

  @Override
  public boolean event() {
    if (new GameOverEvent().event()) {
      System.err.println((ErrorMessage.GOODBUY_MESSAGE));
      return true;
    }
    return false;
  }
}
