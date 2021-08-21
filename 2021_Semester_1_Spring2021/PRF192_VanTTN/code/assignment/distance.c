#include "stdio.h"
#include "math.h"

int main() {
  double x1,y1,x2,y2;
  printf("x1=");
  scanf("%lf", &x1);
  printf("y1=");
  scanf("%lf", &y1);
  printf("x2=");
  scanf("%lf", &x2);
  printf("y2=");
  scanf("%lf", &y2);

  double distance = sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
  printf("Khoảng cách: %lf\n", distance);
  return 0;
}
