def main(n):
    space = [[0 for _ in range(n)] for _ in range(n)]
    state, state_index = [[1, 0], [0, 1], [-1, -1]], 0
    x, y = -1, 0
    printed_value = 1

    for move_count in range(n, 0, -1):
        for _ in range(move_count):
            x, y = list(map)
            _x, _y = state[state_index]
            x += _x
            y += _y
            space[x][y] = printed_value
            printed_value += 1
        state_index = (state_index + 1) % 3
    return [data for row in space for data in row if data != 0]
