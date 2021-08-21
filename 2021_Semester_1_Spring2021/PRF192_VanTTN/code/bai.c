/*
  - tao day n so nguyen ngau nhien (từ 10 đến 100) va tra ve day so nguyen vua tao
  - xuat day vua tao
  - nhap mot so K cần chèn, vị trí cần chèn p. Hay chen k vao day tai vi tri p
  - Nhap day K so nguyen, vi tri can chen p. Hay chen day k so nguyen vao day ban dau da tao
*/

#include <stdio.h>
#include "stdlib.h"

int* input(int size, int min, int max){
  int *arr  = (int*) malloc(size * sizeof(int));
  for(int i = 0; i < size; i++){
    arr[i] = rand() % (max-min+1) + min;
  }
  return arr;
}

void output(int* arr, int size){
  for(int i = 0; i < size; i++){
    printf("%4d", arr[i]);
  }
}

int* insert(int* arr, int size, int value, int index){
  size = size + 1;
  int* result = (int*) realloc(arr, size*sizeof(int));
  for(int i = size-1;i > index;i--){
    result[i] = result[i-1];
  }
  result[index] = value;
  return result;
}

int main(){
  int n;
  printf("Nhap kich thuoc mang:"); scanf("%d", &n);
  int* arr = input(n, 10, 100);
  output(arr, n);
  printf("\n");
  output(insert(arr, n, 109, 2), n+1);
  return 0;
}
