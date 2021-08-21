#include "stdio.h"
#include "stdlib.h"

int* input(int size){
  int *a = (int*) calloc(size, sizeof(int));
  for(int i = 0; i < size; i++){
    printf("a[%d]=", i);
    scanf("%d", &a[i]);
  }

  return a;
}

void printEvenNumbers(int* arr, int size){
  for(int i = 0; i < size; i++){
    if(arr[i] % 2 == 0){
      printf("%4d", arr[i]);
    }
  }
}

int findK(int* arr, int size, int k){
  for(int i = 0; i < size; i++){
    if(arr[i] == k) return i;
  }
  return -1;
}

int* update(int* arr, int size, int updatedPos, int updatedValue){
  int* result = (int*) calloc(size, sizeof(int));
  for(int i = 0; i < size; i++){
    if(i != updatedPos){
      result[i] = arr[i];
    }else result[i] = updatedValue;
  }
  return result;
}

int* delete(int* arr, int size, int deletedPos){
  int* result = (int*) calloc(size-1, sizeof(int));
  int i = 0;
  while(i < size-1){
    if(i < deletedPos) result[i] = arr[i];
    else result[i] = arr[i+1];
    i++;
  }
  return result;
}

int* sort(int* arr, int size){
  int* sorted = (int*) realloc(arr, size);
  for(int i = 0; i < size;i++){
    for(int j = 0; j < size-i-1; j++){
      int tmp = arr[j];
      arr[j] = arr[j+1];
      arr[j+1] = tmp;
    }
  }
  return sorted;
}

int* findAllPos(int* arr, int size, int k){
  int* result = (int*) calloc(1000, sizeof(int));
  int i = 0;
  for(int j = 0; j < size; j++){
    if(arr[j] == k) result[i++] = j;
  }
  return result;
}

void output(int* arr, int size){
  for(int i = 0; i < size; i++)
    printf("%4d", arr[i]);
}

int main(){
  int choice;
  int size;
  printf("size="); scanf("%d", &size);
  int* arr = input(size);
  printEvenNumbers(arr, size);
  printf("\n%d", findK(arr, size, 3));
  output(update(arr, size, 1, -10), size);
  return 0;
}
