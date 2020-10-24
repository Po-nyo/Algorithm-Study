# [[2017 카카오코드 본선] 단체사진 찍기](https://programmers.co.kr/learn/courses/30/lessons/1835)

## 풀이 1
완전탐색을 사용해서 해결할수 있는 간단한? 문제 였다. 다만 hashmap을 재귀함수 호출시 매번 생성할 필요가 없고 한번 생성된 hashmap을 활용하여 구현이 가능했다. 

본 문제의 경우 확인해야할 case 갯수가 8! = 40230 개로 제한되어있으므로 완전탐색으로 풀었지만, 만약 case 갯수가 유동적인 경우 시간복잡도가 초과될 가능성이 있어 다른 방법을 찾아야 한다.

```java
private void dfs(HashMap<Character,Integer> hash) {
    if(hash.size() == people.length) {
      if(verify(hash))
        answer += 1;
    }
    else {
      for(int i = 0; i < people.length; ++i) {
        if(hash.get(people[i]) == null) {
          hash.put(people[i], hash.size());
          dfs(hash);
          hash.remove(people[i]);
        }
      }
    }
  }
```
