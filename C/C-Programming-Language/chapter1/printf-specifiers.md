# Format Specifiers in `printf`

In C, the `printf` function is used to output text to the console. The **format specifiers** in `printf` allow you to control how different data types are displayed.

## Commonly Used Format Specifiers

Below are some frequently used format specifiers in `printf`:

| Specifier | Description                            | Example                            |
| --------- | -------------------------------------- | ---------------------------------- |
| `%d`      | Integer in decimal                     | `printf("%d", 10);` → `10`         |
| `%o`      | Integer in **octal**                   | `printf("%o", 10);` → `12`         |
| `%x`      | Integer in **hexadecimal** (lowercase) | `printf("%x", 255);` → `ff`        |
| `%X`      | Integer in **hexadecimal** (uppercase) | `printf("%X", 255);` → `FF`        |
| `%c`      | **Character**                          | `printf("%c", 'A');` → `A`         |
| `%s`      | **String**                             | `printf("%s", "Hello");` → `Hello` |
| `%%`      | Literal `%` symbol                     | `printf("%%");` → `%`              |

## Explanation of Each Specifier

- **`%d`**: Displays an integer in base 10 (decimal).
- **`%o`**: Converts an integer to base 8 (octal) and displays it.
- **`%x` and `%X`**: Convert an integer to base 16 (hexadecimal). `%x` outputs in lowercase, and `%X` outputs in uppercase.
- **`%c`**: Displays a single character.
- **`%s`**: Displays a character string (null-terminated).
- **`%%`**: Displays a literal `%` character. Useful when you need to print a percent symbol in your text.

## Examples of `printf` with Format Specifiers

```c
#include <stdio.h>

int main() {
    int num = 255;
    char letter = 'A';
    char *word = "Hello";

    printf("Decimal: %d\n", num);      // Decimal: 255
    printf("Octal: %o\n", num);        // Octal: 377
    printf("Hex (lower): %x\n", num);  // Hex (lower): ff
    printf("Hex (upper): %X\n", num);  // Hex (upper): FF
    printf("Character: %c\n", letter); // Character: A
    printf("String: %s\n", word);      // String: Hello

    printf("Percent: %%\n");           // Percent: %

    return 0;
}

```
