#include <stdio.h>
#include <stdlib.h>

int isEqual(int guess, int number);
int isBigger(int guess, int number);
int isSmaller(int guess, int number);
int random_number_generator(int max);

int main() {
  int guess;
  int number = random_number_generator(100);
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

int random_number_generator(int max) {
  return (random() / ((double)RAND_MAX + 1)) * 100;
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
