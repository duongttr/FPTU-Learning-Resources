/*
Viết chương trình in ra menu:
1. Question 1
2. Question 2
3. Exit

Q1: Nhập input x, n (n > 0)
tính f = xˆ1/1! + x^2/2! + ... + x^n/n!
Q2: Nhập chuỗi văn bản (ví dụ: tren tinh ban, duoi tinh yeu). Hãy đảo từ thứ 2 và tứ cuối cùng
*/

#include "stdio.h"
#include "stdlib.h"
#include "string.h"

double calculateEquationQ1(int x, int n){
  double numerator = 1.0;
  double denominator = 1.0;
  double count = 0;
  double result = 0;
  for(int i = 1; i <= n;i++){
    numerator *= x;
    count += 1;
    denominator *= count;
    result += numerator/denominator;
  }
  return result;
}

void Question1(){
  int x, n;
  printf("x="); scanf("%d", &x);
  printf("n="); scanf("%d", &n);
  double result = calculateEquationQ1(x, n);
  printf("f=%lf\n", result);
}



void Question2(){
  fflush(stdin);
  char s[255];
  fgets(s, sizeof(s), stdin);
  int s1, e1, s2, e2;
  int countOrder = 0;
  int turnWhitespace = 0;
  for(int i = 0; i < strlen(s)-1; i++){
    //printf("index = %d\n", (int)s[i]);
    if((int)(s[i]) != 32){
      if(turnWhitespace == 0){
        countOrder += 1;
        s1 = i;
        turnWhitespace = 1;
      }
    }else{
      if(turnWhitespace == 1){
        e1 = i;
        if(countOrder == 2){
          break;
        }
        turnWhitespace = 0;
      }
    }
  } // get second word

  countOrder = 0;
  turnWhitespace = 0;
  for(int i = strlen(s)-2; i >= 0;i--){
    if((int)(s[i]) != 32){
      if(turnWhitespace == 0){
        countOrder += 1;
        e2 = i;
        turnWhitespace = 1;
      }
    }else{
      if(turnWhitespace == 1){
        s2 = i+1;
        if(countOrder == 1){
          break;
        }
        turnWhitespace = 0;
      }
    }
  } // get last word
  //printf("%d\n", strlen(s));
  //printf("%d %d %d %d", s1, e1, s2, e2);

  char result[255];
  int index;
  for(index = 0; index < s1; index++){
    result[index] = s[index];
  }

  int tmps2 = s2;
  while(s2 <= e2){
    result[index] = s[s2];
    s2+=1;
    index+=1;
  }

  for(int i = e1; i < tmps2; i++){
    result[index] = s[i];
    index += 1;
  }

  while(s1 <= e1){
    result[index] = s[s1];
    s1 += 1;
    index += 1;
  }

  printf("%s", result);
}


int main(){
  int choice;
  while(1){
  printf("\n1.Question 1\n2.Question 2\n3. Exit\nYour choice: ");
  scanf("%d", &choice);
  switch (choice) {
    case 1:
      Question1();
      break;
    case 2:
      Question2();
      break;
    case 3:
      exit(0);
  }
}
  return 0;
}
