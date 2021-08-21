#include "stdio.h"
int main(){
  char c;
  printf("Nhập kí tự: ");
  scanf("%c", &c);
  if((c == 'a') || (c == 'e') || (c == 'o') || (c == 'u') || (c == 'i')
      || (c == 'A') || (c == 'E') || (c == 'O') || (c == 'U') || (c == 'I')){
    printf("Nguyên âm\n");
  }else{
    printf("Khác\n");
  }
  return 0;
}
