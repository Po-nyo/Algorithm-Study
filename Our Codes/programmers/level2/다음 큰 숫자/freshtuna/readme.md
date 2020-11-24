# 풀이 1
조건을 필터링 하는 람다 함수나 function을 짜서 활용한다.

```python
func = lambda candidate: len(
    list(filter(lambda x: x == "1", list(str(bin(candidate))))))
count = func(n)
```

# 풀이 2
내장되어있는 count() 함수를 활용한다.
```python
count = bin(n).count('1')
```
