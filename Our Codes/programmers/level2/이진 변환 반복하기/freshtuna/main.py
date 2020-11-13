def call(s):
    if s == "1":
        return [0, 0]
    else:
        zero_removed_length = len(s.replace("0", ""))
        recursive_result = call(f"{zero_removed_length:b}")
        return [recursive_result[0] + 1,
            recursive_result[1] + len(s) - zero_removed_length]

def solution(s):
    return call(s)
