#include "stdio.h"
int main(){
  int income;
  printf("Nhập thu nhập: ");
  scanf("%d", &income);

  int npt;
  printf("Nhập người phụ thuộc: ");
  scanf("%d", &npt);

  double BHXH = income * 0.12;
  double BHYT = income * 0.07;
  double BHTN = income * 0.05;
  double tax = (income - (11000000 + 4600000 * npt + BHYT + BHTN + BHXH)) * 0.05;
  printf("Thuế: %lf\n", tax);
}
