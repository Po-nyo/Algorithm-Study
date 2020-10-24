# [[Leetcode-20] Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## 풀이 1 (스택)
'(', '{', '[' 가 오면 push 하고 그외의 짝이 오면 stack의 마지막 원소와 비교해서 짝이 맞으면 pop한다.
만약 짝이 안맞거나 모든 문자를 trace 한후에도 stack에 문자가 남아 있으면 False를 반환한다.

```python
for char in s:
    if char in left_parentheses:
        stack.append(char)
    else:
        if len(stack) == 0 or stack[-1] != right_parentheses[char]:
            return False
        else: stack.pop()
                
        if len(stack) > 0:
            return False
        
        return True
```
