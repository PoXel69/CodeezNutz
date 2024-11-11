#include <stdio.h>

// i'll write just one blank and if its another blank ill ignore it.
int main() {
  int c, blank;
  blank = 0;
  while ((c = getchar()) != EOF) {
    if (c == ' ' && blank == 0) {
      printf("%c", ' ');
      ++blank;
    } else if (c != ' ') {
      putchar(c);
      blank = 0;
    }
  }
  printf("\n");

  return 0;
}
