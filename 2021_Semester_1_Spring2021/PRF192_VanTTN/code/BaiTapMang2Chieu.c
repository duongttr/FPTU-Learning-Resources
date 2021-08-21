

/*

  1. Tìm MAX_VALUE trong mảng 2 chiều
  2. Nhập vào hàng thứ K bất kì, sắp xếp tăng dần các số trên hàm K
  Ví dụ: K = 1 => sắp xếp tăng dần các số trên hàm 1

  3. Nhập vào số cột, hãy sắp  xếp giảm dần các số trên cột K đó
  4. Hoán vị 2 hàng 0 và 1
  5. Dịch từng cột sang 1 vị trí về phía phải



  BÀI LỚN:
  Viết chương trình quản lý danh sách sinh viên:
  1. Nhập 5 tên sinh viên
  2. Xuất 5 tên sinh viên
  3. In ra tên sinh viên dài nhất
  4. Sắp xếp tăng dần theo tên và tăng dần theo từ điển
  5. Nhập vào tên cần tìm, nếu tìm thấy tên nhân viên trong dãy => tồn tại hay ko tồn tại
  6. Viết hoa đầu các từ trong tên nhân viên
  7. Ghi kết quả sau khi thực hiện vào file trên ổ đĩa cứng tên là: thotinh.txt
*/

#include "stdio.h"
#include "stdlib.h"
#include "time.h"


int** input(int row, int col){
  srand(time(NULL));
  int** arr = (int**) calloc(row, sizeof(int*));
  for(int i = 0; i < row; i++){
    arr[i] = (int*) calloc(col, sizeof(int));
    for(int j = 0; j < col; j++){
      arr[i][j] = rand() % 100;
    }
  }

  return arr;
}

void output(int** arr, int row, int col){
  for(int i = 0; i < row; i++){
    for(int j = 0; j < col; j++){
      printf("%4d", arr[i][j]);
    }
    printf("\n");
  }
}



int main(){
  int r = 5;
  int c = 5;
  int** arr = input(r, c);
  printf("ORIGINAL ARRAY: \n");

  output(arr, r, c);
  return 0;
}
