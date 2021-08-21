U = range(101)

def b2l(C):
    out_C = []
    for i in range(len(C)):
        if C[i]:
            out_C.append(i)
    return out_C

def union(A, B):
    return [A[i] or B[i] for i in U]

def intersect(A, B):
    return [A[i] and B[i] for i in U]

def symdiff(A, B):
    return [A[i] != B[i] for i in U]

def complement(A):
    return [not A[i] if i != 0 else A[i] for i in U]

def diff(A, B):
    return [A[i] and not B[i] for i in U]

if __name__ == '__main__':
    print('A =', end = ' ')
    in_A = list(map(int, input().strip().split()))
    print('B =', end = ' ')
    in_B = list(map(int, input().strip().split()))

    A = [False for _ in U]
    B = [False for _ in U]

    for i in in_A:
        A[i] = True

    for i in in_B:
        B[i] = True

    print(f'A ∪ B = {b2l(union(A, B))}')
    print(f'A ⋂ B = {b2l(intersect(A, B))}')
    print(f'A Δ B = {b2l(symdiff(A, B))}')
    print(f'¬A = {b2l(complement(A))}')
    print(f'A - B = {b2l(diff(A, B))}')
