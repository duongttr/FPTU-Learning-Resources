#include<stdio.h>


void inMenu(){
  printf("1. nhap mot so nguyen\n");
  printf("2. goi ham kiem tra nguyen am\n");
  printf("3. goi ham chuyen chu hoa\n");
}

int nhap1SoNguyen(){
  int choice;
  printf("Nhập 1 số nguyên: ");
  scanf("%d", &choice);
  return choice;
}

void checkCapitalizeLetter(char c){
  if(c >= 'a' && c <= 'z'){
    printf("Kí tự thường\n");
  }else if(c >= 'A' && c <= 'Z'){
    printf("Kí tự hoa\n");
  }else{
    printf("Không phải là một kí tự nằm trong bảng chữ cái\n");
  }
}

int isVowel(char ch){
  if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'u' || ch == 'i'
  || ch == 'A' || ch == 'E' || ch == 'O' || ch == 'U' || ch == 'I'){
    return 1;
  }
  return 0;
}

char convertToCapaital(char ch){
  if(isL){
    return ('a' + 32);
  }
  return ' ';
}

int main()
{
	int choice=4;
	do
	{
		inMenu();
		choice=nhap1SoNguyen();
		switch(choice)
		{
			case 1:
				 fflush(stdin);
         char c;
         printf("Nhập một kí tự: ");
         scanf("%c", &c);
         checkCapitalizeLetter(c);
         printf("\n");
				 break;
			case 2:
			    //goi ham kiem tra nguyen am
				break;
			case 3:
			    //goi ham chuyen chu hoa
				break;
		}
	}
	while(choice != 4);
}
