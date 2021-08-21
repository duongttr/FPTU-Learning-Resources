#include "stdio.h"
#include "string.h"
#include "stdlib.h"

void removeExtraSpace(char str[]){
  int length = strlen(str);
  int i = 0;
  while(i < length-1){
    if(str[i] == ' ' && str[i+1] == ' '){
      for(int j = i+1; j < length-1; j++) str[j] = str[j+1];
    }else{
      i += 1;
    }
  }
}

void output(char str[]){
  for(int i = 0; i < strlen(str); i++){
    printf("%c", str[i]);
  }
}


int main(){
  char str[50];
  fgets(str, sizeof(str), stdin);
  removeExtraSpace(str);
  output(str);
}
