#include "stdio.h"

int main(){
  double chieuDai;
  printf("Nhập chiều dài HCN: ");
  scanf("%lf", &chieuDai);

  double chieuRong;
  printf("Nhập chiều rộng HCN: ");
  scanf("%lf", &chieuRong);

  double p = (chieuDai + chieuRong) * 2;
  double s = chieuDai * chieuRong;

  printf("Chu vi: %lf\n", p);
  printf("Diện tích: %lf\n", s);
}
