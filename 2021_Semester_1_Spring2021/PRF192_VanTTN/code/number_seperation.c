#include "stdio.h"

int main(){
  int n;
  printf("Nhập số nguyên gồm 3 chữ số: ");
  scanf("%d", &n);

  int hangTram = n / 100;
  int hangChuc = (n % 100) / 10;
  int hangDV = (n % 100) % 10;

  printf("Hàng Trăm: %d\nHàng Chục: %d\nHàng ĐV: %d\n", hangTram, hangChuc, hangDV);
  return 0;
}
