package boj_2468;

public class Solution {

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean[][] visited;

    public void solve(int[][] heights, int max_height) {
        int max_area_count = 1;

        for(int i=1; i<max_height; i++) {
            int[][] area = getAreaByRainHeight(heights, i);
            visited = new boolean[area.length][area[0].length];
            int count = 0;

            for(int j=0; j<area.length; j++) {
                for(int k=0; k<area[0].length; k++) {
                    if(!visited[j][k] && area[j][k] == 1)
                        count += dfs(area, j, k);
                }
            }

            max_area_count = Math.max(max_area_count, count);
        }

        System.out.println(max_area_count);
    }

    private int[][] getAreaByRainHeight(int[][] heights, int rain_height) {
        int[][] area = new int[heights.length][heights[0].length];

        for(int i=0; i<heights.length; i++) {
            for(int j=0; j<heights[i].length; j++) {
                if(heights[i][j] > rain_height)
                    area[i][j] = 1;
            }
        }

        return area;
    }

    private int dfs(int[][] area, int row, int col) {
        visited[row][col] = true;

        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow>=0 && newRow<area.length && newCol>=0 && newCol<area[0].length) {
                if(!visited[newRow][newCol] && area[newRow][newCol]==1)
                    dfs(area, newRow, newCol);
            }
        }

        return 1;
    }
}
