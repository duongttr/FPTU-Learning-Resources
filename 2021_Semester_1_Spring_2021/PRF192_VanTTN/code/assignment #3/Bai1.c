#include "stdio.h"

int main(){
  int n;
  int YN;
  do {
    printf("Nhập 1 số: ");

    scanf("%d", &n);
    printf("%d", n);
    fflush(stdin);
    printf("\nMuốn làm nữa không? (1/0): ");
    scanf("\n%d", &YN);

  } while(YN == 1);
  return 0;
}
