# 마을 탐험

## 풀이

Dijkstra 알고리즘을 사용하면 쉽게 해결할 수 있다.

들러야하는 마을에 순서가 있으므로,

시작마을부터 시작해서 이전마을과 다음마을 사이의 최단경로를 Dijkstra 알고리즘으로 구하여 모두 더해주면 된다.

```java
public class Solution {

    public int solve(int[][] graph, int[] items) {
        int start = 0;
        int shortest = 0;

        for(int item : items) {
            shortest += dijkstra(graph, start, item);
            start = item;
        }

        return shortest;
    }

    private int dijkstra(int[][] graph, int start, int end) {
        int[] dp = new int[graph.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;

        boolean[] visited = new boolean[graph.length];
        visited[start] = true;

        for(int i=0; i<dp.length; i++) {
            if(graph[start][i] != 0)
                dp[i] = graph[start][i];
        }

        while(true) {
            int minIndex = getMinIndex(dp, visited);

            if(minIndex == -1)
                break;

            visited[minIndex] = true;

            for(int i=0; i<graph.length; i++) {
                if(graph[minIndex][i] != 0)
                    dp[i] = Math.min(dp[i], dp[minIndex] + graph[minIndex][i]);
            }
        }

        return dp[end];
    }

    private int getMinIndex(int[] dp, boolean[] visited) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for(int i=0; i<dp.length; i++) {
            if(dp[i] < minValue && !visited[i])
                minIndex = i;
        }

        return minIndex;
    }
}
```
