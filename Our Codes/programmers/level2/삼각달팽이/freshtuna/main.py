def solution(n):
    answer = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    x, y = 1, 1
    state, state_index = [[1, 0], [0, 1], [-1, -1]], 0
    objective_count, current_count = n, 0
    current_value = 1
    
    while(True):
        if objective_count == 0: break
        
        answer[x][y] = current_value
        current_count += 1
        current_value += 1
        
        if current_count == objective_count:
            objective_count -= 1
            current_count = 0
            state_index = (state_index + 1) % 3
        _x, _y = state[state_index]
        x += _x
        y += _y

    return list(filter(lambda x: x != 0, [data for row in answer for data in row]))
