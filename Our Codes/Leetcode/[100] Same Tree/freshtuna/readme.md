# [[Leetcode-100] Same Tree](https://leetcode.com/problems/same-tree/)

## 풀이 1
재귀호출을 사용하여 풀수 있다. 트리가 balenced 라면 공간복잡도는 O(logn) 이 될수 있다.

## 풀이 2
재귀호출을 사용하지 말고 스택 자료구조를 활용하여 풀수 있다.
```python
while len(deq) > 0:
    node = deq.pop()
    if node is not None:
        result.append(node.val)
        deq.appendleft(node.left)
        deq.appendleft(node.right)
    else:
        result.append(None)
    return result
```
