#include "stdio.h"
#define PI 3.14
int main(){
  double r;
  printf("Nhập bán kình hình tròn: ");
  scanf("%lf", &r);

  double p = 2*r*PI; // tính chu vi
  double s = r*r*PI; // tính diện tích

  printf("Chu vi: %lf\n", p);
  printf("Diện tích: %lf\n", s);

  return 0;
}
