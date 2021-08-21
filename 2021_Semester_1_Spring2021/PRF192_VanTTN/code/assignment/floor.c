#include "stdio.h"
#include <math.h>

int main(){
  double n;
  printf("Nhập số: ");
  scanf("%lf", &n);

  double decpart = remainder(n, 1);
  //printf("%d\n", remainder(decpart, 1));
  while(remainder(decpart, 1) != 0){
    //printf("%lf\n", decpart - (int)decpart);
    //printf("%lf\n", remainder(decpart, 1));
    decpart *= 10;
  }

  printf("%g\n", decpart);
  //printf("%d\n", decpart);
}
