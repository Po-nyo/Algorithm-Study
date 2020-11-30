package climbing.solution;

import java.util.*;

public class Solution {

    private static class Point {
        private int row;
        private int col;

        private Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String toString() {
            return row + " " + col;
        }
    }

    public int solve(int[][] map, int max_height, int time_limit) {
        int[][] dp = dijkstra(map, new Point(0, 0), max_height);

        int highest = 0;

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                int[][] current_loc_dp = dijkstra(map, new Point(i, j), max_height);

                if(dp[i][j] < Integer.MAX_VALUE && dp[i][j] + current_loc_dp[0][0] <= time_limit)
                    highest = Math.max(highest, map[i][j]);
            }
        }

        return highest;
    }

    private int[][] dijkstra(int[][] map, Point start, int max_height) {
        int[][] dp = new int[map.length][map[0].length];
        for(int[] arr : dp)
            Arrays.fill(arr, Integer.MAX_VALUE);
        dp[start.row][start.col] = 0;

        Set<String> found = new HashSet<>();
        found.add(start.toString());

        Set<String> visited = new HashSet<>();

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        while(true) {
            Point min = getMin(dp, found, visited);

            if(min == null)
                break;

            for(int[] direction : directions) {
                Point p = new Point(min.row + direction[0], min.col + direction[1]);

                if(p.row>=0 && p.col>=0 && p.row<map.length && p.col<map[0].length) {
                    int time_cost = 0;
                    int diff = map[min.row][min.col] - map[p.row][p.col];

                    if(Math.abs(diff) <= max_height) {
                        if (diff > 0)
                            time_cost = 1;
                        else if (diff < 0)
                            time_cost = (int)Math.pow(diff, 2);

                        dp[p.row][p.col] = Math.min(dp[p.row][p.col], dp[min.row][min.col] + time_cost);

                        found.add(p.toString());
                    }
                }
            }
        }

        return dp;
    }

    private Point getMin(int[][] dp, Set<String> found, Set<String> visited) {
        int minValue = Integer.MAX_VALUE;
        Point min = null;

        for(String s : found) {
            if(!visited.contains(s)) {
                String[] parse = s.split(" ");
                int row = Integer.parseInt(parse[0]);
                int col = Integer.parseInt(parse[1]);

                if(dp[row][col] < minValue) {
                    min = new Point(row, col);
                    minValue = dp[row][col];
                }
            }
        }

        if(min != null)
            visited.add(min.toString());
        return min;
    }
}
