def nextBigNumber(n):
    count = bin(n).count('1')

    for case in range(n+1,1000001):
        if bin(case).count('1') == count: return m
