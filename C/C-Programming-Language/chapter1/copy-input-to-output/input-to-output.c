#include <stdio.h>

int main() {
  int c;
  while ((c = getchar()) != EOF) {
    putchar(c);
    printf("\n");
    printf("%d\n", c != EOF);
    printf("%d\n", EOF);
  }
  return 0;
}
