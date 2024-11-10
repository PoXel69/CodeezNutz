#include <stdio.h>
#include <sys/select.h>

int main() {
  /*print Fahrenheit-Celsius table
  for fahr = 0, 20, ..., 300*/
  float fahr, celsius;
  float lower, upper, step;

  lower = 0;   // lower limit of temperature scale
  upper = 300; // uppet limit
  step = 10;   // step size

  celsius = lower;

  printf("A heading Above the Table\n");
  while (celsius <= upper) {
    // Formula for coverting fahrenhite to celsius, C=5(fahr-32)/9
    fahr = celsius * (9.0 / 5.0) + 32;

    printf("%3.0f\t%6.1f\n", celsius, fahr);
    celsius = celsius + step;
  }
}
