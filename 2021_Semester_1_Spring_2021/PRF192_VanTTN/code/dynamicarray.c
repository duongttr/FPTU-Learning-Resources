#include "stdio.h"
#include "stdlib.h"

int *inputNumbers(int n){
    int *arr = (int*) calloc(n, sizeof(int));
    for(int i = 0; i < n;i++){
        printf("n[%d]=", i);
        scanf("%d", &arr[i]);
    }
    return arr;
}

void outputNumbers(int* a, int n){
  for(int i = 0;i < n;i++){
    printf("%4d", a[i]);
  }

  printf("\n");
}

void outputEvenNumbers(int* a, int n){
    for(int i = 0; i < n;i++){
        if(a[i] % 2 == 0){
            printf("%4d", a[i]);
        }
    }
}

int findValueIndex(int* a, int n, int val){
  for(int i = 0; i < n; i++){
    if(a[i] == val){
      return i;
    }
  }
  return -1;
}

void updateNumber(int *a, int n, int updatePos, int newValue){
  if(updatePos >= 0 && updatePos < n) a[updatePos] = newValue;
}

int deleteNumber(int *a, int n, int deletePos){
  for(int i = deletePos; i < n-1;i++){
    a[i] = a[i+1];
  }
  return n-1;
}

void sort(int* a, int n){
  for(int i = 1; i <= n;i++){
    for(int j = 0; j < n-i;j++){
      if(a[j] > a[j+1]){
        int tmp = a[j];
        a[j] = a[j+1];
        a[j+1] = tmp;
      }
    }
  }
}

int main()
{
	int n;
	printf("\nnhap n:");
	scanf("%d",&n);
	int* a=inputNumbers(n);
	//outputNumbers(a,n);
	printf("\n list of even numbers:");
	//outputEvenNumbers(a,n);
  outputNumbers(a, n);
  // updateNumber(a, n, 2, 10);
  // outputNumbers(a, n);
  // n=deleteNumber(a, n, 2);
  // outputNumbers(a, n);
  sort(a,n);
  outputNumbers(a,n);
    free(a);
    return 0;
}
