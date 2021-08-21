#include "stdio.h"

int main(){
  int a,b;
  int tmpA, tmpB;
  printf("a=");
  scanf("%d", &a);
  tmpA = a;
  printf("b=");
  scanf("%d", &b);
  tmpB = b;
  while (a*b > 0) {
    if(a>b) a %= b;
    else b %= a;
  }

  printf("UCLN(%d,%d)=%d\n", tmpA, tmpB, a+b);
  return 0;
}
