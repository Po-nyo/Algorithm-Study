# 한붓 그리기

## 풀이

한붓 그리기는 문제에 나온 조건대로 그래프의 각 정점의 차수들에 의해 결정된다.

조건을 이용하여 다음과 같이 코드를 작성하여 해결했다.

```java
public class Solution {

    public void solve(int[][] graph) {
        List<Integer> oddList = new ArrayList<>();

        for(int i=0; i<graph.length; i++) {
            int degree  = 0;
            for(int j=0; j<graph[i].length; j++) {
                if(graph[i][j] == 1)
                    degree++;
            }
            if(degree % 2 != 0)
                oddList.add(i);
        }

        if(oddList.size() == 0)
            System.out.println("O");
        else if(oddList.size() == 2 || graph[oddList.get(0)][oddList.get(1)] == 1) {
            System.out.println("O");
        }
        else
            System.out.println("X");
    }
}
```
