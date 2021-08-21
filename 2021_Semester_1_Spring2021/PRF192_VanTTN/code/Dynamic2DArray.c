#include "stdio.h"
#include "stdlib.h"
#include "time.h"

int** input(int r, int c){
  srand(time(NULL));

  int** arr = (int**) calloc(r, sizeof(int*));
  for(int i = 0; i < r; i++){
    int col = rand() % 10 + 1;
    //printf("%d\n", col);
    printf("\n");
    int* a = (int*) calloc(col, sizeof(int));
    for(int j = 0; j < col; j++){
      a[j] = rand() % 10 + 1;
      printf("%5d", a[j]);
    }
    arr[i] = a;
  }

  return arr;
}

void output(int** arr, int r, int c){
  for(int i = 0; i < r; i++){
    for(int j = 0; j < c; j++){
      printf("%4d", arr[i][j]);
    }
    printf("\n");
  }
}

int main(){
  int r = 100;
  int c = 20;
  input(r,c);
  //output(input(r,c),r, c);
  return 0;
}
