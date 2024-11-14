#include <stdio.h>
int main() {
  int guess, number;
  number = 6;
  while (scanf("%d", &guess) != EOF) {
    if (guess == number) {
      printf("You took the W\n");
      break;
    } else if (guess > number) {
      printf("you guessed too High!\nTry Again.\n");
    } else if (guess < number) {
      printf("you guessed too Low!\nTry Again.\n");
    }
  }
}
