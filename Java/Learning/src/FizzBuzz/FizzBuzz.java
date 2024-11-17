package FizzBuzz;

import java.util.List;

public class FizzBuzz {

  static void fizzBuzz(List<Integer> number) {
    for (Integer i : number) {
      if (i % 5 == 0 && i % 3 == 0) {
        System.out.println("FizzBuzz");
      } else if (i % 3 == 0) {
        System.out.println("Fizz");
      } else if (i % 5 == 0) {
        System.out.println("Buzz");
      } else {
        System.out.println(i);
      }
    }
  }
}
