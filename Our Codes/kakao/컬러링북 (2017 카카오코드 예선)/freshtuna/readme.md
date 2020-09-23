# [[2017 카카오코드 예선] 카카오프렌즈 컬러링북](https://programmers.co.kr/learn/courses/30/lessons/1829)

## 풀이 1 
전형적인 탐색 문제의 일종으로 BFS 알고리즘을 사용하여 해결할수 있다.
재귀 호출 보다는 스택으로 BFS를 구현해야 스택오버플로우를 방지할수 있다.

```java
// 주요 코드
private static void push_candidates(int x, int y) {
  // 배열을 만들어서 과도한 조건절의 사용을 지양할수 있습니다.
  int[][] candidates = {{x + 1, y}, {x - 1, y}, {x, y - 1}, {x, y + 1}};
  int color = picture[x][y];

  for(int i = 0; i < candidates.length; ++i) {
    int _x = candidates[i][0];
    int _y = candidates[i][1];

    if (
      _x >= 0 && _x < m && _y >= 0 && _y < n 
      && picture[_x][_y] == color 
      && visited[_x][_y] == false
    ) { 
      push(_x, _y);
      area++; 
    }
  }
}
```
