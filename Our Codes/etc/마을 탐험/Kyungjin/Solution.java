package village_tour.solution;

import java.util.Arrays;

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
