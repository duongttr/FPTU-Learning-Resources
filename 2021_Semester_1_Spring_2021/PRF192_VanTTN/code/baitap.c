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

void outMinToMax(int* arr, int size, int min, int max){
    for(int i = 0; i < size;i++){
      if(arr[i] >= min && arr[i] <= max){
        printf("%4d", arr[i]);
      }
    }
}

int main(){
  int n;
  printf("Nhap kich thuoc mang: ");
  scanf("%d", &n);
  int* arr = input(n);
  printf("Cac so chan trong mang la: "); printEvenNumbers(arr, n);

  int min, max;
  printf("\nmin=");
  scanf("%d", &min);
  printf("max=");
  scanf("%d", &max);
  printf("Gia tri nam giua %d va %d: ", min, max);outMinToMax(arr, n, min, max);
  return 0;
}
