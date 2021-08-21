#include "stdio.h"
#include <stdbool.h>

int getMax(int a, int b, int c){
  int result = a;
  if(result < b) result = b;
  if(result < c) result = c;
  return result;
}

int getMin(int a, int b, int c){
  int result = a;
  if(result > b) result = b;
  if(result > c) result = c;
  return result;
}

bool isNegative(int n){
  return n < 0;
}

bool isPositive(int n){
  return n >= 0;
}


int main(){
  int a, b, c;
  scanf("%d%d%d", &a, &b, &c);
  printf("max=%d\n", getMax(a,b,c));
  printf("min=%d\n", getMin(a,b,c));
  return 0;
}
