def solution(n):
    space = [0 for _ in range(n + 1)]
    space[1] = 1
    
    for _n in range(2, n + 1):
        space[_n] = space[_n - 1] + space[_n - 2]
    return space[n] % 1234567
