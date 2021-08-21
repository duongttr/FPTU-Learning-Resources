#include "stdio.h"

#include "stdlib.h"

#include "string.h"

double getSum(double x, int n) {
    double f = 1;
    double factorial = 1;
    int count = 1;
    for (int i = 1; i <= n; i++) {
        factorial *= count;
        count += 1;
        f += (x - i) / factorial;
    }
    return f;
}

void Question1() {
    double x;
    int n;
    printf("x=");
    scanf("%lf", & x);
    printf("n=");
    scanf("%d", & n);
    if (n > 0) {
        printf("getSum(%lf, %d)=%lf\n", x, n, getSum(x, n));
    } else {
        printf("n should be greater than 0\n");
    }

}

char * subString(char * s, int index, int length) {
    char * result = (char * ) malloc(length);
    int currIndex = 0;
    for (int i = index; i < index + length; i++) {
        result[currIndex] = s[i];
        currIndex += 1;
    }
    return result;
}

void Question2() {

    char s[1000];
    int index, length;
    fflush(stdin);
    printf("s=");
    fgets(s, sizeof(s), stdin);
    fflush(stdin);
    printf("index=");
    scanf("%d", & index);
    printf("length=");
    scanf("%d", & length);
    if (index >= 0 && index < strlen(s) - 1 && length >= 0 && index + length >= 0 && index + length < strlen(s) - 1) {
        printf("%s\n", subString(s, index, length));
    } else {
        printf("Out of range!\n");
    }
}

int * reverse(int * list, int length) {
    int * result = (int * ) calloc(1000, sizeof(int));
    for (int i = length - 1; i >= 0; i--) {
        result[i] = list[length - 1 - i];
    }
    return result;
}

int * split(int number) {
    int * result = (int * ) calloc(1000, sizeof(int));
    int index = 0;
    while (number > 0) {
        result[index] = number % 10;
        //printf("%d\n", result[index]);
        number /= 10;
        index += 1;
    }
    return reverse(result, index);
}

int getLength(int number) {
    int c = 0;
    while (number > 0) {
        number /= 10;
        c++;
    }
    return c;
}

void Question3() {

    int number;
    printf("number=");
    scanf("%d", & number);
    int tmpNum = number;
    if (number > 0) {
        printf("numbers after splitting: ");
        int * result = split(number);
        int length = getLength(tmpNum);
        //printf("%d\n", length);
        for (int i = 0; i < length - 1; i++) {
            printf("%d,", result[i]);
        }
        printf("%d\n", result[length - 1]);
    } else {
        printf("The input number should be positive!\n");
    }

}

int main() {
    while (1) {
        int choice;
        printf("\n1.Question 1\n2.Question 2\n3.Question 3\n4. Exit\nYour choice: ");
        scanf("%d", & choice);
        switch (choice) {
        case 1:
            Question1();
            break;
        case 2:
            Question2();
            break;
        case 3:
            Question3();
            break;
        case 4:
            exit(0);
        }
    }

    return 0;
}
