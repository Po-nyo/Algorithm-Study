def sub_solution(arr, length, center_x, center_y):
    result = [0, 0]

    if length == 2:
        cases = [arr[center_x][center_y], 
            arr[center_x - 1][center_y], arr[center_x][center_y - 1],
            arr[center_x - 1][center_y - 1]] 
        for case in cases: result[case] += 1
        if result[0] == 0: return [0, 1]
        elif result[1] == 0: return [1, 0]
        else: return result
    else:
        cases = [[center_x - length // 4, center_y - length // 4], 
         [center_x - length // 4, center_y + length // 4], 
         [center_x + length // 4, center_y - length // 4], 
         [center_x + length // 4, center_y + length // 4]]

        for case in cases:
            case_result = sub_solution(arr, length // 2, *case)
            result[0] += case_result[0]
            result[1] += case_result[1]
        
        if result[0] == 0: return [0, 1]
        elif result[1] == 0: return [1, 0]
        else: return result

def solution(arr):
    return sub_solution(arr, len(arr), len(arr) // 2, len(arr) // 2)

print(solution([[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]))
