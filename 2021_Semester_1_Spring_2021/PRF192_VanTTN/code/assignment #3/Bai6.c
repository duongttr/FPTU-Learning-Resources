#include "stdio.h"

int main(){
  for (int i=2;i<=8;i+=2){
      int remain=20-2*i;
      for (int j=remain;j>=0;j--){
          for (int k=20-remain-j;k>=0;k--){
              if ((j<=9) && (k<=9)) printf("%d%d%d%d\n", i, j, k, i);;
          }
      }
  }
  return 0;
}
