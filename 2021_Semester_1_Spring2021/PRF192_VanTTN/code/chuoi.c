#include "stdio.h"
#include "string.h"

int main() {
  char s[] = "Hello there b";
  char k = 'h';
  char* kq = strchr(s, k);
  printf("%", kq);
}

/*
  - Nhập tên sv có độ dài tối đa 50 kí tự (khai báo 51)
  - Xuất tên vừa nhập
  - Chèn chữ "Mr" trước tên vừa nhập, xuất kết quả sau khi nhập
  - Xuất chiều dài tên sau khi chèn

  - Nhập vào tên sinh viên thứ 2, so sánh tên thứ 2 với tên thứ 1 (< or > or =)
  - Xoá khoảng trắng vừa đầu, vừa đuôi của tên vừa nhập.
*/
