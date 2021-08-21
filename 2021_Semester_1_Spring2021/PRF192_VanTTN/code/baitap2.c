#include "stdio.h"
#include "stdlib.h"
#include "time.h"

int* input(int size){
  srand(time(NULL));

  int* arr = (int*) malloc(size * sizeof(int));
  for(int i = 0; i < size; i++){
    arr[i] = rand() % 51;
  }
  return arr;
}

void output(int* arr, int size){
  for(int i = 0; i < size;i++){
    printf(" %d ", arr[i]);
  }
}

int getMax(int* arr, int size){
  int max = arr[0];
  for(int i = 1; i < size;i++){
    if(arr[i] > max){
      max = arr[i];
    }
  }
  return max;
}

int getSum(int* arr, int size){
  long s = 0;
  for(int i = 0; i < size; i++){
    s += arr[i];
  }
  return s;
}

float getAvg(int* arr, int size){
  return (float)getSum(arr, size) / size;
}

int main(){
  int n;
  printf("N="); scanf("%d", &n);
  int* arr = input(n);
  output(arr, n);

  printf("\nMAX=%d", getMax(arr, n));
  printf("\nSUM=%d", getSum(arr, n));
  printf("\nAVG=%f", getAvg(arr, n));
  printf("\n");
  return 0;
}
