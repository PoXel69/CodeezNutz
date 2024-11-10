#include <stdio.h>

int main() {
  /*print Fahrenheit-Celsius table
  for fahr = 0, 20, ..., 300*/

  float fahr, celsius;
  float lower, upper, step;

  lower = 0;   // lower limit of temperature scale
  upper = 300; // uppet limit
  step = 20;   // step size

  fahr = lower;

  printf("A heading Above the Table\n");
  while (fahr <= upper) {
    // Formula for coverting fahrenhite to celsius, C=5(fahr-32)/9

    celsius = (5.0 / 9.0) * (fahr - 32.0);
    printf("%3.0f\t%6.1f\n", fahr, celsius);
    fahr = fahr + step;
  }
}
