# 협곡에 숨은 티모 찾기

## 풀이

처음 언뜻 문제를 읽고나서 DFS나 BFS로 탐색해야하나 싶었지만 자세히 들여다보니 아니었다.

나는 그냥 모든 위치에 대해 8방향으로 탐색하는 방법으로 해결했다.

탐색하는 도중에 티모가 없을 것 같으면 바로 손을 떼는 방식이다.

협곡 맵을 입력 받을 때, 원본 grid와 함께 원소를 모두 소문자로 바꾼 clone도 같이 만들었다.

대소문자를 구분하지 않기 때문에

탐색은 clone으로 하고, 마지막에 버섯으로 초토화된 지역은 원본 grid에 표시해주려는 의도이다.

관련 코드는 다음과 같다.

```java
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int m = scan.nextInt();
    int n = scan.nextInt();
    scan.nextLine();

    char[][] grid = new char[m][n];
    char[][] clone = new char[m][n];

    for(int i=0; i<m; i++) {
        String line = scan.nextLine();
        for(int j=0; j<n; j++) {
            grid[i][j] = line.charAt(j);
            clone[i][j] = Character.toLowerCase(grid[i][j]);
        }
    }

    new Solution().solve(grid, clone);
}
```

main()메소드에서 grid와 clone을 Solution()객체의 solve() 메소드에 넘겨 문제를 해결한다.

Solution()의 기본적인 구조는 다음과 같은 모양이다.

```java
public class Solution {

    static class Point {
        private int row;
        private int col;

        private Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private String word;
    private Set<Point> targetPoints;

    public Solution() {
        this.word = "teemo";
        this.targetPoints = new HashSet<>();
    }
}
```

nested class Point를 작성하여 위치를 표현하는데 사용했다.

word는 찾는 대상인 "teemo"이고, targetPoints는 버섯으로 초토화되는 지점이다.

사용자에 의해 실제로 호출되는 메소드는 solve()이고 다음과 같다.

```java
public void solve(char[][] grid, char[][] clone) {
    for(int i=0; i<clone.length; i++) {
        for(int j=0; j<clone[i].length; j++) {
            scan(clone, i, j);
        }
    }
    bomb(grid);
    print(grid);
}
```

나는 기능별로 나누어 구현하는것을 좋아해서 크게 세 가지 기능으로 나누어 구현했다.

1. scan(): 티모를 찾고, 초토화 지점 결정
2. bomb(): 찾은 초토화지점 초토화
3. print(): 협곡 맵 출력

scan() 부터 살펴보자.

```java
private void scan(char[][] clone, int startRow, int startCol) {
    Set<Point> points = new HashSet<>();

    int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    for(int i=0; i<dr.length; i++) {
        points.clear();
        boolean camo_flag = false;
        int camo_count = 0;

        int row = startRow - dr[i];
        int col = startCol - dc[i];

        for(int j=0; j<this.word.length(); j++) {
            row += dr[i];
            col += dc[i];

            if(row >= 0 && row < clone.length && col >= 0 && col < clone[0].length) {
                points.add(new Point(row, col));

                if(clone[row][col] != this.word.charAt(j)) {
                    if(camo_flag || camo_count > 1)
                        break;
                    camo_flag = true;
                    camo_count++;
                }
                else
                    camo_flag = false;

                if(j == this.word.length()-1)
                    this.targetPoints.addAll(points);
            }
            else
                break;
        }
    }
}
```

points()에 초토화가 될 수도 있는 지점을 저장해두었다가, 탐색이 끝나 티모가 발견되면 targetPoints에 추가한다.

티모가 발견되지 않으면 저장해두었던 points()는 초기화된다.

티모는 연속되지 않게 두 문자를 위장할 수 있기 때문에

위장 횟수는 camo_count에 저장하고, 연속된 위장 체크는 camo_flag로 체크한다.

연속된 문자로 위장하거나, camo_count가 2가 넘으면 티모를 발견하지 못한 것으로 간주한다.

<br>

다음은 targetPoints에 저장된 위치를 초토화 시키는 bomb()이다.

```java
private void bomb(char[][] grid) {
    for(Point p: this.targetPoints) {
        grid[p.row][p.col] = '#';
    }
}
```

협곡 맵을 출력하는 print()이다.

```java
private void print(char[][] grid) {
    for(char[] arr: grid) {
        for(char c: arr)
            System.out.print(c);
        System.out.println();
    }
}
```