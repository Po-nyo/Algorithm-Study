# [[BOJ-2468] 안전 영역](https://www.acmicpc.net/problem/2468)

## 풀이

2차원 배열을 탐색하여 영역을 구하는 문제이다.

나는 물의 높이에 따라 잠기지 않는 영역을 1, 잠기는 영역을 0으로 하여 새로운 배열을 만들고

만든 배열을 DFS 방식으로 탐색하여 영역의 개수를 구했다.

문제의 조건에서 비가 오지 않는 경우도 있다고 했으므로, 처음 최대 영역의 개수는 1로 설정했다.

문제 해결은 다음 과정을 거친다.

1. 물의 높이에 따라 잠기는 영역과 그렇지 않은 영역을 구분한 area 배열을 만듬
2. area 배열에서 아직 방문하지 않았고, 새로운 영역인 경우에 대해 DFS 진행
3. 안전 영역의 최대 개수 갱신
4. 1 ~ 3번을 물의 높이가 1인 경우부터 가장 높은 경우까지 진행

```java
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
```
