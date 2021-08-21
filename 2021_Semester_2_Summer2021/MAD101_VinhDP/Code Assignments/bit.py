"""
Tìm tất cả các dãy số bit độ dài n mà có không quá ba số 0 liền kề nhau
ví dụ: 01, 001, 000100, 00001(invalid), 1010000 (invalid)
"""

def solve(n, no_zero = 3, keeper_no_zero = 3):
    tmp0 = []
    tmp1 = []
    if n == 1:
        if no_zero > 0:
            return ['0', '1']
        else:
            return ['1']

    if no_zero > 0:
        tmp0 = ['0' + i for i in solve(n-1, no_zero - 1)]
    tmp1 = ['1' + i for i in solve(n-1, keeper_no_zero)]
    return tmp0 + tmp1


if __name__ == '__main__':
    print('n=', end='')
    n = int(input())
    print('k=', end='')
    k = int(input())
    if (n >= k):
        print(solve(n, k, k))
    else:
        print('n must be >= k')
