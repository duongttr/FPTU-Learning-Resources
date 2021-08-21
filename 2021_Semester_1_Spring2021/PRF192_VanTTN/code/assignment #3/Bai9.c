#include "stdio.h"
#include <stdlib.h>
#include <time.h>

int main(){
  time_t t;
  srand((unsigned) time(&t));
  int min, max;
  printf("min=");
  scanf("%d", &min);
  printf("max=");
  scanf("%d", &max);
  int r = rand();
  //r %= 100000;
  //printf("%d", r);
  while (r >= min && r <= max) {
    printf("%d ", r);
    r = rand();
    //r %= 100000;
  }
  return 0;
}
