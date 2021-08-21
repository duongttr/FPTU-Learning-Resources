#include<stdio.h>
#include<stdlib.h>
#include<curses.h>
#include<math.h>

void Bai1()
{
	int i;
	for(i=1;i<=5;i++){
		printf("\nEm yeu co");
	}fflush(stdin);
}
void Bai2()
{
	int i;
	for (i=1;i<=100;i++){
		printf("\n%d",i);
	}fflush(stdin);
}
void Bai3()
{
	int i;
	for(i=100;i>=0;i--){
		printf("\n%d",i);
	}fflush(stdin);
}
void Bai4()
{
	int i,n;
	printf("Nhap n: ");
	scanf("%d",&n);
	for (i=1;i<=n;i+=2){
		printf("\n%d",i);
	}fflush(stdin);
}
void Bai5()
{
	int n;
	printf("Nhap n: ");
	scanf("%d",&n);
	for(;n>0;){
		n -= 2;
		printf("\n%d",n);
	}fflush(stdin);
}
void Bai6()
{
	int n,s,i;
	printf("Nhap n: ");
	scanf("%d",&n);
	for(s=0,i=1;i<=n;i++){
		s=s+i;
	}
	printf("Tong la: %d",s);fflush(stdin);
}

void Bai7()
{
	int n,s,i;
	printf("Nhap n: ");
	scanf("%d",&n);
	for(s=0,i=1;i<=n;i++){
		if(i%2==0){
			s=s-i;
		}
		else{
			s=s+i;
		}
	}
	printf("KQ la: %d",s);fflush(stdin);
}

void Bai8()
{
	int n,s,i;
	printf("Nhap n: ");
	scanf("%d",&n);
	for(s=1,i=1;i<=n;i++){
		s=s*i;
	}
	printf("KQ la: %d",s);fflush(stdin);
}

void Bai9()
{
	int n,i;
	float s=0;
	printf("Nhap n: ");
	scanf("%d",&n);
	for(i=2;i<=n;i++){
		s=s+1/(float)i;
	}
	printf("KQ la: %.2f",s);fflush(stdin);
}
void Bai10()
{
	int n,i;
	float s=0;
	printf("Nhap n: ");
	scanf("%d",&n);
	for(i=1;i<=n;i++){
		s=s+(float)i/(float)(i+1);
	}
	printf("KQ la: %.3f",s);fflush(stdin);
}
void Bai11()
{
	int n,i,k;
	printf("Nhap n: ");
	scanf("%d",&n);
	for(i=1;i<=n;i++){
		for(k=1;k<=i;k++){
			printf("*");
		}
		printf("\n");
	}fflush(stdin);
}
void Bai12()
{
	int n,i,k;
	printf("Nhap n: ");
	scanf("%d",&n);
	for(i=1;i<=n;i++){
		for(k=1;k<=i;k++){
			if(k==1||i==k||i==n){
				printf("*");
			}
			else{
				printf(" ");
			}
		}
		printf("\n");
	}fflush(stdin);
}
void Bai13()
{
	int k,i,n;
	printf("Nhap k: ");
	scanf("%d",&k);
	for(i=1;i<=10;i++){
		n=i*k;
		printf("%d x %d = %d",k,i,n);
		printf("\n");
	}fflush(stdin);
}
void Bai14()
{
	int k,i,n;
	for(k=2;k<=9;k++){
		for(i=1;i<=10;i++){
			n=i*k;
			printf("%d x %d = %d",k,i,n);
			printf("\n");
		}
	}fflush(stdin);
}
void Bai15()
{
	int day,month,year,m,y,a,b,c,tong;
	printf("Nhap ngay: ");
	scanf("%d",&day);
	printf("Nhap thang: ");
	scanf("%d",&month);
	printf("Nhap nam: ");
	scanf("%d",&year);
	for(a=0,y=1;y<year;y++){
		if(y%4==0&&y%100!=0||y%400==0)
			a+=366;
		else a+=365;
	}
	for(b=0,c=0,m=1;m<month;m++){
		switch (m){
			case 3: case 5: case 7: case 8: case 10: case 12:
				b+=31;break;
			case 4: case 6: case 9: case 11:
				c+=30;
		}
	}
	if((year%4==0&&year%100!=0||year%400==0)&&month>=2){
		tong=a+b+c+day+29+31;
		printf("Tong so ngay: %d",tong);
	}
	else{
		if(month<2){
			tong=a+b+c+day;
		}
		else{
			tong=a+b+c+day+28+31;
		}
	}
	printf("Tong so ngay: %d",tong);fflush(stdin);
}
void Bai16()
{
	int day,month,year,m,y,a,b,c,tong,du;
	printf("Nhap ngay: ");
	scanf("%d",&day);
	printf("Nhap thang: ");
	scanf("%d",&month);
	printf("Nhap nam: ");
	scanf("%d",&year);
	for(a=0,y=2000;y<year;y++){
		if(y%4==0&&y%100!=0||y%400==0)
			a+=366;
		else a+=365;
	}
	for(b=0,c=0,m=1;m<month;m++){
		switch (m){
			case 3: case 5: case 7: case 8: case 10: case 12:
				b+=31;break;
			case 4: case 6: case 9: case 11:
				c+=30;
		}
	}
	if((year%4==0&&year%100!=0||year%400==0)&&month>=2){
		tong=a+b+c+day+29+31-1;
		printf("Tong so ngay: %d",tong);
	}
	else{
		if(month<2){
			tong=a+b+c+day-1;
		}
		else{
			tong=a+b+c+day+28+31-1;
		}
	}
	printf("Tong so ngay: %d",tong);
	printf("\n");
	du=tong%7;
	switch(du){
		case 0:printf("Hom nay la thu 7");break;
		case 1:printf("Hom nay la chu nhat");break;
		case 2:printf("Hom nay la thu 2");break;
		case 3:printf("Hom nay la thu 3");break;
		case 4:printf("Hom nay la thu 4");break;
		case 5:printf("Hom nay la thu 5");break;
		case 6:printf("Hom nay la thu 6");break;
	}fflush(stdin);
}
void Bai17()
{
exit (0) ;
}
int main()
{
    char YN;
    int choice;
	do
	{
		printf("MENU");
		printf("\n1.VCT in ra em yeu co 5 lan");
		printf("\n2.VCT in ra 1,2,3,...,100");
		printf("\n3.VCT in ra 100,99,...,0");
		printf("\n4.VCT in ra 1,3,5,...,n");
		printf("\n5.VCT in ra n,n-2,n-4,...,0");
		printf("\n6.VCT tinh 1+2+3+...+n");
		printf("\n7.VCT tinh 1-2+3-4+...+n");
		printf("\n8.VCT tinh 1*2*3*...*n");
		printf("\n9.VCT tinh 1/2+1/3+...+1/n");
		printf("\n10.VCT tinh 1/2+2/3+...+n/(n+1)");
		printf("\n11.VCT in ra tam giac dac");
		printf("\n12.VCT in ra tam giac rong");
		printf("\n13.VCT in ra bang cuu chuong n");
		printf("\n14.VCT in ra bang cuu chuong tu 2 den 9");
		printf("\n15.VCT tinh so ngay");
		printf("\n16.VCT xuat thu");
		printf("\n17.Thoat");
		printf("\nNhap option: ");
		scanf("%d",&choice);
		fflush(stdin);
		switch(choice)
		{
			case 1:
				Bai1();
				break;
			case 2:
				Bai2();
				break;
			case 3:
				Bai3();
				break;
			case 4:
				Bai4();
				break;
			case 5:
				Bai5();
				break;
			case 6:
				Bai6();
				break;
			case 7:
				Bai7();
				break;
			case 8:
				Bai8();
				break;
			case 9:
				Bai9();
				break;
			case 10:
				Bai10();
				break;
			case 11:
				Bai11();
				break;
			case 12:
				Bai12();
				break;
			case 13:
				Bai13();
				break;
			case 14:
				Bai14();
				break;
			case 15:
				Bai15();
				break;
			case 16:
				Bai16();
				break;
			case 17:
				Bai17();
				break;
		}
		printf("\nCo muon lam nua khong(Y/N): ");
		scanf("%c",&YN);
		fflush(stdin);
	}
	while (YN=='Y' || YN== 'y');

	return 0;
}
