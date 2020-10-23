import math
from collections import Counter

def make_set(line):
    _set = list()
    for i in range(len(line) - 1):
        candidate = line[i:i + 2]
        if candidate.isalpha(): _set.append(candidate)
    return _set

def solution(str1, str2):
    str1, str2 = str1.lower(), str2.lower()
    set1, set2 = list(map(make_set, [str1, str2]))
    intersection = list((Counter(set1) & Counter(set2)).elements())
    union = list((Counter(set1) | Counter(set2)).elements())
    return 65536 if len(union) == 0 else math.trunc(len(intersection) \
        / len(union) * 65536)

if __name__ == "__main__":
    print(solution("aa1+aa2", "AAAA12"))
