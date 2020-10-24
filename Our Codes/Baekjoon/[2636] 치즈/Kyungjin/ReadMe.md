# [[BOJ-2636] 치즈](https://www.acmicpc.net/problem/2636)

## 풀이

DFS 나 BFS 로 치즈 바깥 부분의 공기를 탐색하는 방식으로 해결할 수 있는 문제이다.

나는 치즈의 크기가 0이 될 때 까지 바깥 공기와 맞닿은 치즈를 없애는 DFS 를 진행했다.

치즈의 크기가 0이 되었을 경우에, 0이 되기 직전 시각의 치즈의 크기를 출력해야 하므로

따로 저장해두었다가 출력해주었다.

<br>

DFS 진행 방식

1. 바깥 부분의 공기를 (0, 0) 위치부터 네 방향으로 탐색을 시작한다.
2. 배열을 벗어나지 않는 위치에 대하여 값이 0이면 Stack 에 집어넣고, 값이 1이면 값을 0으로 만든다.
3. 2번에서 값에 상관없이 visited 를 true 로 체크하여 작업을 중복으로 진행하지 않게 한다.

```java
private void rot() {
    this.prev_cheese_area = this.cheese_area;
    this.cheese_area = 0;
    boolean[][] visited = new boolean[cheese_arr.length][cheese_arr[0].length];

    Stack<Point> stack = new Stack<>();
    stack.push(new Point(0, 0));
    visited[0][0] = true;

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while(!stack.isEmpty()) {
        Point current = stack.pop();

        for(int[] direction : directions) {
            int row = current.row + direction[0];
            int col = current.col + direction[1];

            if (row >= 0 && row < cheese_arr.length && col >= 0 && col < cheese_arr[0].length) {
                if(!visited[row][col] && cheese_arr[row][col] == 0) {
                    stack.push(new Point(row, col));
                    visited[row][col] = true;
                }
                else if(cheese_arr[row][col] == 1) {
                    this.cheese_area++;
                    cheese_arr[row][col] = 0;
                    visited[row][col] = true;
                }
            }
        }
    }
}
```
