def solve(n):
    if n == 1:
        return ['1']
    elif n == 2:
        return ['11', '2']
    else:
        return [(s + '1') for s in solve(n-1)] + [(s + '2') for s in solve(n-2)]

def optimized_solve(n):
    s1 = ['1']
    s2 = ['11', '2']
    s3 = []
    if n == 1:
        return s1
    elif n == 2:
        return s2
    else:
        for _ in range(3, n+1):
            s3 = [(s + '1') for s in s2] + [(s+'2') for s in s1]
            s1 = s2
            s2 = s3
    return s2

if __name__ == '__main__':
    print('Input n:', end=' ')
    n = int(input())
    print(', '.join(optimized_solve(n)))
