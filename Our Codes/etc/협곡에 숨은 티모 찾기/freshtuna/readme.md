# 협곡에 숨은 티모 찾기

## 풀이 1

뭔가 특별한 알고리즘이 아니라 배열을 모두 탐색해가며 일단 풀었다. 
다만 코드를 읽기(?) 쉽게 작성하기 위해 검사해야 하는 경우의 수를 배열로 나타내여 아래와 같이 활용했다.

```python
def trace(self, i, j):
    _out_of_range = False
    out = 0

    for array in self.trace_arrays(i, j):
        for index, pos in enumerate(array):
            x, y = pos
            if self.out_of_range(x, y): 
                _out_of_range = True 
                break
            if not self.correct(index, x, y): out += 1
        # check
        if not _out_of_range and out <= 2: self.bomb(array)
        _out_of_range, out = [False, 0]

# 검사해야할 경우의수를 배열로 생성
def trace_arrays(self, i, j):
    return [
        [[i, j], [i + 1, j], [i + 2, j], [i + 3, j], [i + 4, j]],
        [[i, j], [i - 1, j], [i - 2, j], [i - 3, j], [i - 4, j]],
        [[i, j], [i, j + 1], [i, j + 2], [i, j + 3], [i, j + 4]],
        [[i, j], [i, j - 1], [i, j - 2], [i, j - 3], [i, j - 4]],
        [[i, j], [i + 1, j + 1], [i + 2, j + 2], [i + 3, j + 3], [i + 4, j + 4]],
        [[i, j], [i - 1, j + 1], [i - 2, j + 2], [i - 3, j + 3], [i - 4, j + 4]],
        [[i, j], [i + 1, j - 1], [i + 2, j - 2], [i + 3, j - 3], [i + 4, j - 4]],
        [[i, j], [i - 1, j - 1], [i - 2, j - 2], [i - 3, j - 3], [i - 4, j - 4]]
    ]
```
