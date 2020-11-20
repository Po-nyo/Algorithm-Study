# 풀이 1
전형적인 분할정복 문제이다. 문제를 작은 문제로 쪼갠다음 큰 문제의 답을 구할때 활용한다.
이 문제는 예를 들면, 가장 큰 정사각형의 답은 4분할된 정사각형들의 답의 합으로 구할수 있음에 착안하여 해결하면 된다.

```python
cases = [[center_x - length // 4, center_y - length // 4], 
         [center_x - length // 4, center_y + length // 4], 
         [center_x + length // 4, center_y - length // 4], 
         [center_x + length // 4, center_y + length // 4]]

        for case in cases:
            case_result = sub_solution(arr, length // 2, *case)
            result[0] += case_result[0]
            result[1] += case_result[1]
```
