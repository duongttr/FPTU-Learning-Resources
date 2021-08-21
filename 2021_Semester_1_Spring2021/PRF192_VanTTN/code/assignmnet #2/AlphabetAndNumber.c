#include "stdio.h"
int main(){
  char c;
  printf("Nhập kí tự: ");
  scanf("%c", &c);
  if(((c >= 65) && (c <= 90)) || ((c >= 97) && (c <= 122))){
    printf("Alphabet\n");
  }else if((c >= '0') && (c <= '9')){
    printf("Số\n");
  }
  else{
    printf("Khác\n");
  }
  return 0;
}
