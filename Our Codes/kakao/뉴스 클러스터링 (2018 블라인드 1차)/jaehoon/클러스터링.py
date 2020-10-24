"""
자카드 유사도

두 집합 A, B 사이의 자카드 유사도 J(A, B)는
두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의

예를 들어,
- 집합 A = {1, 2, 3}, 집합 B = {2, 3, 4}라고 할 때,
교집합 A ∩ B = {2, 3}, 합집합 A ∪ B = {1, 2, 3, 4}이 되므로,
집합 A, B 사이의 자카드 유사도 J(A, B) = 2/4 = 0.5가 된다.

- 집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다.

- 자카드 유사도는 원소의 중복을 허용하는 다중집합에 대해서 확장할 수 있다.
다중집합 A는 원소 1을 3개 가지고 있고, 다중집합 B는 원소 1을 5개 가지고 있다고 하자.
이 다중집합의 교집합 A ∩ B는 원소 1을 min(3, 5)인 3개, 합집합 A ∪ B는 원소 1을 max(3, 5)인 5개 가지게 된다.
다중집합 A = {1, 1, 2, 2, 3}, 다중집합 B = {1, 2, 2, 4, 5}라고 하면,
교집합 A ∩ B = {1, 2, 2}, 합집합 A ∪ B = {1, 1, 2, 2, 3, 4, 5}가 되므로,
자카드 유사도 J(A, B) = 3/7, 약 0.42가 된다.
"""


def split_string(string):
    list_ = list()
    for i in range(len(string)):
        if (i + 1) == len(string):
            break

        if string[i].isalpha() and string[i+1].isalpha():
            list_.append(string[i:i+2])

    return list_


def jacc(str1, str2):
    union, intersection = list(), list()

    for element in str1:
        if str2.count(element) == 0:
            union.append(element)
        else:
            intersection.append(element)
            str2.remove(element)

    union += str2

    union_len = len(union)
    inter_len = len(intersection)
    if union_len == 0 and inter_len == 0:
        return 1

    return inter_len / (union_len + inter_len)


def solution(str1, str2):
    str1 = split_string(str1.upper())
    str2 = split_string(str2.upper())
    return int(jacc(str1, str2) * 65536)
#
# import sys
#
#
# def split_string(string):
#     list_ = list()
#     for i in range(len(string)):
#         if (i + 1) == len(string):
#             break
#
#         if string[i].isalpha() and string[i+1].isalpha():
#             list_.append(string[i:i+2])
#
#     return list_
#
#
# def jacc(str1, str2):
#     union, intersection = list(), list()
#
#     for element in str1:
#         if str2.count(element) == 0:
#             union.append(element)
#         else:
#             intersection.append(element)
#             str2.remove(element)
#
#     union += str2
#
#     union_len = len(union)
#     inter_len = len(intersection)
#     if union_len == 0 and inter_len == 0:
#         return 1
#
#     return inter_len / (union_len + inter_len)
#
#
# if __name__ == '__main__':
#     strip_str1 = (split_string(sys.stdin.readline().rstrip('\n').upper()))
#     strip_str2 = (split_string(sys.stdin.readline().rstrip('\n').upper()))
#
#     print(int(jacc(strip_str1, strip_str2) * 65536))
