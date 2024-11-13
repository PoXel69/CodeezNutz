/* replace every
 * tabs with \t
 * backslash with \\
 * backspace with \b
 */

#include <stdio.h>

int main() {
  int c;

  while ((c = getchar()) != EOF)
    if (c == 8) {
      putchar('\\');
      putchar('b');
    } else if (c == 92) {
      putchar('\\');
      putchar('\\');
    } else if (c == 9) {
      putchar('\\');
      putchar('t');
    }
  putchar(c);
  return 0;
}
