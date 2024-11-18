#include <stdio.h>

int isEqual(int guess, int number);
int isBigger(int guess, int number);
int isSmaller(int guess, int number);

int main() {
  int guess, number;
  number = 6;
  printf("Hello & Welcome\n");
  printf("Please guess a number (hint: dont guess %i): ", number);
  while (scanf("%d", &guess) != EOF) {
    if (isEqual(guess, number)) {
      printf("You took the W\n");
      break;
    } else if (isBigger(guess, number)) {
      printf("you guessed too High!\nTry Again.\n");
    } else if (isSmaller(guess, number)) {
      printf("you guessed too Low!\nTry Again.\n");
    }
  }
}
int isEqual(int guess, int number) {
  if (guess == number)
    return 1;

  return 0;
}
int isBigger(int guess, int number) {
  if (guess > number)
    return 1;
  return 0;
}
int isSmaller(int guess, int number) {
  if (guess < number)
    return 1;
  return 0;
}
