def solution(A,B):
    answer = 0
    A, B = sorted(A), sorted(B).reverse()
    for i in range(len(A)): answer += A[i] * B[i]
    return answer
