import sys


a, b = map(int, sys.stdin.readline().split())
numbers = list(map(int, sys.stdin.readline().rstrip('\n').split()))

ultra, rare, super_, normal = 0, 0, 0, 0

for j in range(1, a+1, 1):
    if j & (j - 1) == 0:
        ultra += 1
    else:
        count = 0

        for num in numbers:
            if j % num == 0:
                count += 1

        if count >= 3:
            ultra += 1
        elif count >= 2:
            rare += 1
        elif count >= 1:
            super_ += 1
        else:
            normal += 1

print("{} {} {} {}".format(ultra, rare, super_, normal))
