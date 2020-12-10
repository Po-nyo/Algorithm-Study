def main(n):
    space = [[0 for _ in range(n)] for _ in range(n)]
    state, state_index = [[1, 0], [0, 1], [-1, -1]], 0
    x, y = -1, 0
    value = 1

    for move_count in range(n, 0, -1):
        for _ in range(move_count):
            x += state[state_index][0]
            y += state[state_index][1]
            space[x][y] = value
            value += 1
        state += 1
    
    return [for row in space for data in row if data != 0]
