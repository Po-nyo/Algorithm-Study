def solution(n):
    func = lambda candidate: len(list(
        filter(lambda x: x == "1", list(str(bin(candidate))))))
    count = func(n)

    for case in range(n + 1,1000001):
        if func(case) == count: return candidate
