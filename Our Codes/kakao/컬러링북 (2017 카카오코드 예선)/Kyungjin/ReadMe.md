# [[2017 카카오코드 예선] 카카오 프렌즈 컬러링북](https://programmers.co.kr/learn/courses/30/lessons/1829)

## 풀이

사실 그렇게 어렵지 않은 문제인데, 나는 문제를 잘못 읽어버려서 좀 고생했다.

이번 문제를 해결하면서 문제를 좀 더 꼼꼼히 읽고 살펴봐야겠다는 교훈을 얻었다.

본론으로 넘어와서 본격적으로 문제를 풀어보면, 이 문제는 DFS나 BFS를 영역별로 진행하여 해결할 수 있다.

나는 DFS로 문제를 해결했다.

현재 탐색 위치는 다음과 같이 Solution 클래스 내부에 nested class를 선언하여 사용했다.

```java
static class Point {
    private int row;
    private int col;
    
    private Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
```

m, n, picture 를 입력받아 영역의 개수와 가장 넓은 영역의 크기를 반환해주는 solution() 메소드는 다음과 같이 작성했다.

```java
public int[] solution(int m, int n, int[][] picture) {
    boolean[][] visited = new boolean[m][n];
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            if(!visited[i][j] && picture[i][j] != 0) {
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(picture, visited, i, j));
                numberOfArea++;
            }
        }
    }
    
    return new int[]{numberOfArea, maxSizeOfOneArea};
}
```

solution() 메소드 에서는 (0, 0)부터 (m-1, n-1)까지 진행하면서,

색칠된 영역이고 아직 방문되지 않은 지점에 대해 DFS를 진행하여 영역의 개수를 추가하고 가장 넓은 영역의 크기를 갱신한다.

다음은 DFS를 진행하는 dfs() 메소드 이다.

```java
private int dfs(int[][] picture, boolean[][] visited, int startRow, int startCol) {
    int color = picture[startRow][startCol];
    int areaSize = 0;
    
    Stack<Point> stack = new Stack<>();
    stack.push(new Point(startRow, startCol));
    
    visited[startRow][startCol] = true;
    
    while(!stack.isEmpty()) {
        Point current = stack.pop();
        areaSize++;
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for(int[] direction : directions) {
            int row = current.row + direction[0];
            int col = current.col + direction[1];
            
            if(row >= 0 && row < picture.length && col >= 0 && col < picture[0].length) {
                if(picture[row][col] == color && !visited[row][col]) {
                    stack.push(new Point(row, col));
                    visited[row][col] = true;
                }
            }
        }
    }
    return areaSize;
}
```

DFS를 진행하기 위해 처음엔 재귀로 코드를 작성했다가 Stack Overflow 에러날까봐 Stack을 사용하는 것으로 바꿨다.

진행 알고리즘은 이렇다.

1. Stack에서 하나 꺼내고(현재 위치), areaSize를 1 증가시킨다.
2. 현재 위치로 부터 상하좌우 네 방향에 대해 탐색하여 (0, 0) ~ (m, n) 범위 내에 있고, 방문하지 않은 위치이면 Stack에 넣는다.
3. Stack이 빌 때 까지 1 ~ 2 를 반복한다.
4. 구해진 영역의 넓이(areaSize)를 반환한다.
