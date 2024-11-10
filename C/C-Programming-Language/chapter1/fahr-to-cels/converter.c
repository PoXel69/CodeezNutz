#include <stdio.h>

int main() {
  /*print Fahrenheit-Celsius table
  for fahr = 0, 20, ..., 300*/

  int fahr, celsius;
  int lower, upper, step;

  lower = 0;   // lower limit of temperature scale
  upper = 300; // uppet limit
  step = 20;   // step size

  fahr = lower;

  while (fahr <= upper) {
    // Formula for coverting fahrenhite to celsius, C=5(fahr-32)/9
    celsius = 5 * (fahr - 32) / 9;
    printf("%3d\t%6d\n", fahr, celsius);
    fahr = fahr + step;
  }
}
