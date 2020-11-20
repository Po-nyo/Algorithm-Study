def solution(s):
    result, flag = "", True
    for x in s:
        if x == " ": 
            flag = True
            result += x
        else:
            if flag == True:
                result += x.upper()
                flag = False
            else:
                result += x.lower()
    return result
