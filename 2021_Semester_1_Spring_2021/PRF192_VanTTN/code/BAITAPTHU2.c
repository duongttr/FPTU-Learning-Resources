#include "stdio.h"
#include "stdlib.h"

void input(int a[], int size){
  for(int i = 0; i < size; i++){
    a[i] = rand() % 2;
  }
}

void output(int a[], int size){
  for(int i = 0; i < size; i++){
    printf("%4d", a[i]);
  }
}

int getOddSum(int a[], int size){
  int s = 0;
  for(int i = 0; i < size;i++){
    s += (a[i] % 2 != 0 ? a[i] : 0);
  }
  return s;
}

int main(){
  int N;
  printf("n="); scanf("%d", &N);
  int a[N];
  input(a, N);
  output(a, N);
  printf("\nSUM = %d\n", getOddSum(a, N));
  return 0;
}
