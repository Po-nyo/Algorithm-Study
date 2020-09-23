# [[Leetcode-344] Reverse String](https://leetcode.com/problems/reverse-string/)

## 풀이 1 
일반적인 풀이법은 배열의 마지막원소 부터 첫번째 원소의 순서로 탐색하면서 해를 구하는 방법이다.
이처럼 순서가 반대로 될때는 스택을 사용하는것을 고려해보면 좋다. 람다식을 사용하여 간결하게 만들수도 있다.

```python
class Solution:
    def reverseString(self, s: List[str]) -> None:
        answer = []
        while len(s) > 0: answer.append(s.pop())
        return answer
```

```python
# 람다식 사용
import functools 
class Solution:
    def reverseString(self, s: List[str]) -> None:
        return reduce(lambda last_result, new :[new] + last_result, s, [])
```

## 풀이 2
배열 선형탐색으로 풀수 있는 문제는 재귀적으로 풀수 있는 경우도 많다! n번째 해 = n-1 번째 해 + 첫번째원소 의 형태로 점화식을 생각해볼수 있다.

```python
class Solution:
    def reverseString(self, s: List[str]) -> None:
        s = self._reverseString(s)
        
    def _reverseString(self, s: List[str]) -> None:
        return self._reverseString(s[1:]) + [s[0]] if len(s) > 0 else []
```

## 풀이 3
파이썬이 제공하는 builtin 함수를 사용한다.
```python
class Solution:
    def reverseString(self, s: List[str]) -> None:
        return s.reverse()
```
