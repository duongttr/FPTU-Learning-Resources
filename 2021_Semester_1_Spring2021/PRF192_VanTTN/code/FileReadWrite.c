/*
  Cho sẵn 1 file văn bản có tên "thotinh.txt" chứa nội dung:
  "Abc
  Def
  fgh
  hik"
  - Sử dụng ngôn ngữ C để đọc file văn bản trên và cất nó vào mảng ký tự.
  - Đổi mảng ký tự thành chữ hoa
  - Ghi mảng kết quả vào file "backup.txt"
*/

#include "stdio.h"
#include "string.h"

void readFileToArray(char s[], char fileName[]){
  FILE* f = fopen(fileName, "r");
  if(f != NULL){
    int i = 0;
    while(feof(f) == 0){
      int tmp = fgetc(f);
      s[i] = tmp;
      i++;
    }
    s[i-1] = '\0';
    fclose(f);
  }
}

void toUppercase(char* s){
  for(int i = 0; i < strlen(s); i++){
    if(s[i] >= 'a' && s[i] <= 'z'){
      s[i] -= 32;
    }
  }
}

void writeArrayToFile(char s[], char fileName[]){
  FILE* f = fopen(fileName, "w");
  if(f != NULL){
    fputs(s, f);
    fclose(f);
  }
}

int main(){
  char fileName[] = "/Users/jaydentran1909/Documents/Spring2021/PRF192/code/thotinh.txt";
  char data[1000];
  readFileToArray(data, fileName);
  puts(data);
  toUppercase(data);
  puts(data);
  writeArrayToFile(data, "/Users/jaydentran1909/Documents/Spring2021/PRF192/code/backup.txt");
  return 0;
}
