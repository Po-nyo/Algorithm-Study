# 조별리그

## 풀이
정렬을 할때 어떻게 할까 고민을 많이 했던 문제였다. 우선 팀정보를  hash table을 사용하여 저장한 다음 (팀이름 key, 팀정보 value) key 배열 뽑아내서 정해진 규칙을 정해서 정렬한후 출력했다. 

다시 생각해보니 굳이 hash table을 썻아야 햇나 싶기도 하고 ㅋㅋ 그냥 객체 배열써서 푸는게 더 좋은 방법인것 같다.

파이썬에서는 정렬을 하기위해 자바의 Comparator 와 유사한 functools의 cmp_to_key 함수를 사용하였다.

```python
def comparator(self, a, b):
    def compare_winning(a, b):
      a, b = a["win"], b["win"]
      return -1 if a > b else (1 if a < b else 0)

    def compare_plus_minus(a, b):
      a, b = a["plus"] + a["minus"], b["plus"] + b["minus"]
      return -1 if a > b else (1 if a < b else 0)

    def compare_latest_fight(a, b, latest_result):
      a_b = latest_result[a["index"]][b["index"]]
      b_a = latest_result[b["index"]][a["index"]]
      return -1 if a_b == 1 else (1 if b_a == 1 else 0)

    a, b = self.team[a], self.team[b]
    result = compare_winning(a, b)
    if result != 0: return result
    
    result = compare_plus_minus(a, b)
    if result != 0: return result

    return compare_latest_fight(a, b, self.latest_result)

# 이렇게 한다!
sorted(self.team.keys(), 
    key=functools.cmp_to_key(self.comparator)))
```
