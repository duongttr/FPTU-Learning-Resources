#include "stdio.h"

int main(){
  int n;
  int YN;


  do {
    int result = 1;
    printf("n=");
    scanf("%d", &n);
    while (n > 0) {
      result *= n;
      n--;
    }
    printf("%d\n", result);
    printf("\nMuốn làm nữa không? (1/0): ");
    scanf("\n%d", &YN);
  } while(YN == 1);
  return 0;
}
