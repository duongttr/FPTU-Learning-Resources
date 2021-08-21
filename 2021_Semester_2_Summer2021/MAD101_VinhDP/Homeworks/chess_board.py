"""
Bài toán quân Hậu: trên một bàn cờ nxn, hãy xếp n quân hậu lên bàn cờ mà không
có bất kì quận hậu nào có thể ăn quân hậu nào
"""
count = 0
def solve(n, board, cc, cd1, cd2, i):
    if i < n:
        for j in range(n):
            if cc[j] and cd1[i+j] and cd2[i-j+n-1]:
                cc[j] = False
                cd1[i+j] = False
                cd2[i-j+n-1] = False
                X[i] = j
                solve(n, X, cc, cd1, cd2, i+1)
                cc[j] = True
                cd1[i+j] = True
                cd2[i-j+n-1] = True
                X[i] = -1
    else:
        global count
        count += 1
        # for i in range(n):
        #     s = ['_'] * n
        #     s[X[i]] = 'X'
        #     print(' '.join(s))
        # print('\n')


if __name__ == '__main__':
    print('n=',end='')
    n = int(input())
    cCol = [True for _ in range(n)]
    cDiag1 = [True for _ in range(2*n - 1)]
    cDiag2 = [True for _ in range(2*n - 1)] # plus n-1 when check this diagonal
    X = [-1 for _ in range(n)]
    solve(n, X, cCol, cDiag1, cDiag2, 0)
    print(count)
