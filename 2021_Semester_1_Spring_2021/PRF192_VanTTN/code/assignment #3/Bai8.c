#include "stdio.h"

int main(){
  int c;
  do {
    printf("Nhap mot so: ");
    scanf("%d", &c);
    fflush(stdin);
  } while(c < 0 || c > 255);
  return 0;
}
