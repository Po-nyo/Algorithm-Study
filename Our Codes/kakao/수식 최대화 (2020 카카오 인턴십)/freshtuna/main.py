def calc(priority, n, expression):
    if n == 2:
        return str(eval(expression))
    else:
        return str(eval(priority[n].join([calc(priority, 
            n+1, e) for e in expression.split(priority[n])])))

def solution(expression):
    from itertools import permutations
    answer = 0
    priority_cases = permutations(["+", "-", "*"], 3)
    for priority in priority_cases:
        answer = max(answer, abs(int(calc(priority, 0, expression))))
    return answer
