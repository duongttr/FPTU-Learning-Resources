#include "stdio.h"
#include <stdlib.h>

int main(){
  char c1, c2;

  printf("Ký tự đầu tiên: ");
  scanf("%c", &c1);
  fflush(stdin);
  printf("Ký tự thứ hai: ");
  scanf("%c", &c2);

  printf("Khoảng cách = %d\n", abs(c1 - c2));

  return 0;
}
