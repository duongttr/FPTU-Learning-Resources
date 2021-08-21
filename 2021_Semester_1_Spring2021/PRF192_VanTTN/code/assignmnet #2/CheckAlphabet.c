#include "stdio.h"
int main(){
  char c;
  printf("Nhập kí tự: ");
  scanf("%c", &c);
  if(((c >= 65) && (c <= 90)) || ((c >= 97) && (c <= 122))){
    printf("Alphabet\n");
  }else{
    printf("Khác\n");
  }
  return 0;
}
