#include "stdio.h"

int main(){
  char c;
  do {

    printf("Nhập một kí tự: ");
    scanf("%c", &c);
    fflush(stdin);
    if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
      printf("%c\n", c);
    }
  } while(c != '0');
  return 0;
}
