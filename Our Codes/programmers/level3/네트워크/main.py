def solution(n, computers):
    answer = 0
    visit = [False for _ in range(n)]
    i = 0

    while False in visit:
        if visit[i] == False:
            stack = [start]
            while stack:
                element = stack.pop()
                if visit[element] == False: visit[element] = True
                for i in range(len(computers[0])):
                    if computers[element][i] == 1 and visit[i] == 0:
                        stack.append(i)
            answer += 1
        i += 1
    return answer

