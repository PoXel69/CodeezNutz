package utils;

import java.util.Random;

public class RandomNumberGenerator {

  public int randomNumberGenerator(int startOfRange, int endOfRange) {
    return new Random().nextInt(endOfRange - startOfRange + 1) + startOfRange;
  }
}
