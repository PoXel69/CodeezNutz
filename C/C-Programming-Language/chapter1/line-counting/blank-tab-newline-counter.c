#include <stdio.h>

int main() {

  int c;
  int tab, blank, nl = 0;
  while ((c = getchar()) != EOF)
    if (c == '\t') {
      ++tab;
    } else if (c == '\n') {
      ++nl;
    } else if (c == ' ') {
      ++blank;
    } else {
      printf("%c\n", c);
    }
  printf("Tabs: %d\n", tab);
  printf("New Lines: %d\n", nl);
  printf("Spaces: %d\n", blank);

  return 0;
}
