#include "stdio.h"

int main(){
  char c;
  printf("Nhập ký tự chữ hoa: ");
  scanf("%c", &c);

  printf("Ký tự thường: %c\n", c+32);
  return 0;
}
