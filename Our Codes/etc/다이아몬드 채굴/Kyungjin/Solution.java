package diamond_area.solution;

public class Solution {

    private int areaNum;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean[][] visited;

    public void solve(int[][] map) {
        this.areaNum = 1;
        this.visited = new boolean[map.length][map[0].length];

        int[][] diamond_area = new int[map.length][map[0].length];

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(!visited[i][j] && map[i][j]==1) {
                    dfs(map, diamond_area, i, j);
                    areaNum++;
                }
            }
        }

        printArea(diamond_area);
    }

    public void dfs(int[][] map, int[][] diamond_area, int row, int col) {
        visited[row][col] = true;
        diamond_area[row][col] = areaNum;

        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow>=0 && newRow<map.length && newCol>=0 && newCol<map[0].length) {
                if(!visited[newRow][newCol] && map[newRow][newCol]==1)
                    dfs(map, diamond_area, newRow, newCol);
            }
        }
    }

    public void printArea(int[][] diamond_area) {
        for(int[] arr : diamond_area) {
            for(int i : arr)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
