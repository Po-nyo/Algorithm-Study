# [[2018 블라인드 1차] 뉴스 클러스터링](https://programmers.co.kr/learn/courses/30/lessons/17677?language=python3)

## 풀이 1
문자열의 길이가 2~1000 여서 공간복잡도가 안전한 범위? 로 정해저 있으므로 완전탐색을 사용해서 해결할수 있는 문제이다. 다만 집합을 구할때 중복을 허용해야 하므로 set이 아닌 list를 써야 하고, 구한 집합을 이용하여 합집합, 교집합을 구할때도 set을 쓸수 없으므로 Counter를 활용해서 해결해야 한다.


```python
# Counter로 중복 집합간의 교집합과 합집합을 구할수 있다.
intersection = list((Counter(set1) & Counter(set2)).elements())
union = list((Counter(set1) | Counter(set2)).elements())
```
