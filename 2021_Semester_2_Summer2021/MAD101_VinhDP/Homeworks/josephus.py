"""
Bài toán Josephus: Cho n tên trộm và một số k. Xếp n tên trộm này thành một vòng
tròn và được đánh số từ 1 tới n. Mỗi một vòng, những tên trộm đứng tại vị trí là
bội số của k (i*k) sẽ bị giết chết. Sau khi loại bỏ những tên đã chết,
chúng ta sẽ bắt đầu một vòng mới đối với những tên còn sống.
Làm cho đến khi chỉ còn 1 tên trộm còn sống. Hãy tìm tên trộm đó. (in ra
số được đánh dấu của tên trộm)
"""

def josephus(n, k):
    if n == 1:
        return 1
    else:
        return (josephus(n-1,k) + k - 1) % n + 1

if __name__ == '__main__':
    print('n=',end='')
    n = int(input())
    print('k=',end='')
    k = int(input())
    print('The chosen one is: ', josephus(n, k))
