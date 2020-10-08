# [[Leetcode-67] Add Binary](https://leetcode.com/problems/add-binary/)

## 풀이 1
1. 먼저 자릿수를 맞춘다.
2. 맨마지막 원소 부터 덧셈을 진행한다. (편의를 위해 배열의 순서를 뒤집는다)
3. 덧셈을 모두 진행하고 올림수가 있으면 반영한다.

## 풀이 2
파이썬이 제공하는 이진연산 라이브러리로 쉽고 빠르게 풀수 있다!

```python
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        return f'{int(a, base=2) + int(b, base=2):b}'
```

## 풀이 3
비트 연산을 활용해 더강력 하게 풀수 있다!
낮은 비트 부터 or 연산을 시행하여 자릿수를 구하고 and 연산을 한후 left shift를 하여
carry를 발생시킨다.

```python
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        x = int(a,2)
        y = int(b,2)
        while y:
            answer=x^y
            carry=(x& y)<<1
            x,y=answer,carry
        # return binary string
        # 앞에 붙은 0b 형식을 제거하고 출력한다.
        return bin(x)[2:]
```
