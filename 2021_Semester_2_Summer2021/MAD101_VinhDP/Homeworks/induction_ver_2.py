def solve(n):
    if n == 1:
        return ['1']
    else:
        ret = []
        for i in range(1, n):
            ret += [s + '+' +str(i) for s in solve(n-i)]
        ret.append(str(n))
        return ret

if __name__ == '__main__':
    print('Input n:', end=' ')
    n = int(input())
    print('\n'.join(solve(n)))
