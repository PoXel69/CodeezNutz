package Primes;

import java.util.List;
import java.util.stream.IntStream;

public class Prime {
  private final int start;
  private final int end;

  public Prime(int end) {
    this.end = end;
    start = 0;
    primeFinder(range(start, end));
  }

  public Prime(int start, int end) {
    this.start = start;
    this.end = end;
    primeFinder(range(start, end));
  }

  private static void primeFinder(List<Integer> number) {
    for (Integer i : number) {
      System.out.println(isPrime(i) ? i + " Is a Prime" : i + " Is not a Prime");
    }
  }

  private static boolean isPrime(int num) {
    if (num < 2) return false;
    for (int j = 2; j <= Math.sqrt(num); j++) {
      if (num % j == 0) {
        return false;
      }
    }
    return true;
  }

  List<Integer> range(int start, int end) {
    return IntStream.range(start, end).boxed().toList();
  }
}
