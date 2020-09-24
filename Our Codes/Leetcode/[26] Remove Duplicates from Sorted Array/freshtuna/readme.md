# [[Leetcode-26] Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

## 풀이 1 (재귀 기법)
n번째 해 = 기존값들과 다른 값을 가진 수 + (n-1)번째 해

```python
class Solution:
    def removeDuplicates(self, nums) -> int:
        def _removeDuplicates(nums, last=nums[0]):
            for i in range(len(nums)):
                if nums[i] != last:
                    return [last] + _removeDuplicates(nums[i:], nums[i])
            return [last]
        return _removeDuplicates(nums)
```

## 풀이 2 (재귀 기법, lambda with reduce)
```python
from functools import reduce
class Solution:
    def removeDuplicates(nums) -> int:
        return reduce(
            lambda answer, operand: 
                answer + [operand] if answer[-1] != operand else answer, 
            nums, [nums[0]])
```

## 풀이 3
파이썬이 제공하는 해시 테이블을 역이용 한다.
```python
class Solution:
    def removeDuplicates(nums) -> int:
        return list(dict.fromkeys(nums))
```

## 풀이 4
파이썬이 제공하는 집합 자료형을 역이용한다.
```python
class Solution:
    def removeDuplicates(nums) -> int:
        return list(set(num))
```
