# Dijkstra 알고리즘

## 풀이

Dijkstra 알고리즘은 한 정점에서부터 다른 모든 정점까지의 최단경로를 구하는 알고리즘이다.

맨처음에 시작 정점으로부터 갈 수 있는 정점에 대한 비용을 저장한 자료구조를 만든다.

이 때, 갈 수 없는 정점에 대한 비용은 무한대이다.

이후부터는 아직 방문하지않은 정점 중에 비용이 가장 낮은 정점을 선택하여,

해당 정점을 경유하면 비용이 더 작아지는 경우에 대해 값을 갱신하는 작업을 반복한다.

Dijkstra 알고리즘은 dp 방식으로 진행된다.

```java
public class Solution {

    public int solve(int[][] graph, int start, int via, int end) {
        int start_to_via = dijkstra(graph, start, via);
        int via_to_end = dijkstra(graph, via, end);

        if(start_to_via == Integer.MAX_VALUE || via_to_end == Integer.MAX_VALUE)
            return -1;

        return start_to_via + via_to_end;
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