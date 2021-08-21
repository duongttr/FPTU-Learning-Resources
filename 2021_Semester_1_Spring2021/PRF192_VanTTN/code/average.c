#include "stdio.h"
int main() {
  double LT;
  printf("Điểm lý thuyết = ");
  scanf("%lf", &LT);
  double TT;
  printf("Điểm thực hành = ");
  scanf("%lf", &TT);
  double avg = (LT+TT) / 2;
  printf("Điểm trung bình = %lf\n", avg);
  return 0;
}
