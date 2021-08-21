#include "stdio.h"

int main(){
  int luongCB;
  printf("Nhập tiền lương cơ bản: ");
  scanf("%d", &luongCB);

  float ngayCong;
  printf("Nhập ngày công: ");
  scanf("%f", &ngayCong);

  int tienThuong;
  printf("Nhập tiền thưởng: ");
  scanf("%d", &tienThuong);

  float luong = luongCB * ngayCong + tienThuong;

  printf("Lương: %lf\n", luong);
}
