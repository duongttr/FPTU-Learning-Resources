#include "stdio.h"
#include "string.h"

void generateRandomFile(char* fileName){
  srand(time(NULL));
  FILE* f = fopen(fileName, "w");
  if(f != NULL){
    int n = rand() % 100 + 1;
    for(int i = 0; i < n;i++){
      fputc(, f);
    }
    fclose(f);
  }
}

int readFile(int a[], char* fileName){
  FILE* f = fopen(fileName, "r");
  int n = 0;
  if(f != NULL){
    fscanf(f, "%d", &n);
    for(int i = 0; i < n; i++){
      fscanf(f, "%d", &a[i]);
    }
    fclose(f);
  }
  return n;
}

void bubbleSort(int a[], int n){
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n-i-1; j++){
      if(a[j] > a[j+1]){
        int tmp = a[j];
        a[j] = a[j+1];
        a[j+1] = tmp;
      }
    }
  }
}

void writeText(int a[], int n){
  for(int i = 0; i < n; i++){
    printf("%4d", a[i]);
  }
  printf("\n");
}


int main(){
  int a[1000];
  int n = readFile(a, "/Users/jaydentran1909/Documents/Spring2021/PRF192/code/before.txt");
  writeText(a, n);
  bubbleSort(a, n);
  writeText(a, n);
  return 0;
}
