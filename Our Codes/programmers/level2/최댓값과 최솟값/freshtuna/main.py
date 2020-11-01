def solution(s):
    s = sorted(list(map(int, s.split())))
    return f'''{s[0]} {s[-1]}'''
