#include "stdio.h"
#include "stdlib.h"
#include "time.h"

void input(int m[][3], int r, int c){
  srand(time(NULL));
  for(int i = 0; i < r; i++){
    for(int j = 0; j < c; j++){
      // printf("arr[%d][%d]=", i, j);
      // scanf("%d", &m[i][j]);
      m[i][j] = rand() % 100;
    }
  }
}

void output(int m[][3], int r, int c){
  for(int i = 0; i < r; i++){
    for(int j = 0; j < c; j++){
      printf("%4d", m[i][j]);
    }
    printf("\n");
  }
}

int main(){
  int r = 2;
  int c = 3;
  int m[r][c];

  input(m, r, c);
  output(m, r, c);
  return 0;
}
