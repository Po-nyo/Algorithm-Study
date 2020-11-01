def solution(land):
    for i in range(1, len(land)):
        for j in range(4):
            max_value = 0
            for z in range(4):
                if j != z and max_value < land[i - 1][z]: 
                    max_value = land[i - 1][z]
            land[i][j] += max_value
    return max(land[-1])
