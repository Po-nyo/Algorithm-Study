def min_to_correct_char(character):
    up_count = ord(character) - ord('A')
    down_count = ord('Z') - ord(character) + 1
    return min(up_count, down_count)

def calculate_right_count(index, name):
    for i in range(1,len(name)):
        if name[index+i] != "A": return i
    return 21

def calculate_left_count(index, name):
    for i in range(1,len(name)):
        if name[index-i] != "A": return i
    return 21

def solution(name):
    answer = 0
    name = list(name)
    objective_name = ["A"] * len(name)
    index = 0

    while(True):
        if name[index] != 'A': 
            answer += min_to_correct_char(name[index])
            name[index] = 'A'

        if name == objective_name: break

        left_count = calculate_left_count(index, name) 
        right_count = calculate_right_count(index, name)

        if right_count <= left_count:
            answer += right_count
            index += right_count
        elif right_count > left_count:
            answer += left_count
            index -= left_count
    return answer

print(solution("JEROEN"))
