#include <stdio.h>
int main() {
  int fahr;
  for (fahr = 0; fahr <= 300; fahr = fahr + 20) {
    float celsius = (5.0 / 9.0) * (fahr - 32);

    printf("%3d %6.1f\n", fahr, celsius);
  }
  return 0;
}
