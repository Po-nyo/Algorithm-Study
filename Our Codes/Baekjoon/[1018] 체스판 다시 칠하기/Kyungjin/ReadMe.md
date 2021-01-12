# [[BOJ-1018] 체스판 다시 칠하기](https://www.acmicpc.net/problem/1018)

## 풀이

체스판의 각 row index, column index를 체스판을 8x8 로 쪼개는 시작 위치로 생각하여

countDiff() 메소드에 입력하면 쪼갠 체스판에 대하여 두 가지 패턴을 고려한 최소 수정값을 반환한다.

가능한 모든 시작 위치에 대하여 반환된 수정값 중 최소값을 출력했다.

패턴은 흰색 또는 검정색으로 시작하는 패턴을 각각 0, 1로 생각하여 처리했다.

0, 1 을 1과 ^ 연산하면 반대값이 나오는 것을 활용했다.

<br>

```java
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        char[][] chessBoard = new char[n][m];

        scan.nextLine();
        for(int i=0; i<n; i++) {
            String line = scan.nextLine();
            for(int j=0; j<m; j++)
                chessBoard[i][j] = line.charAt(j);
        }

        int min = n * m;
        outer_loop:
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i + 8 > chessBoard.length)
                    break outer_loop;
                else if(j + 8 > chessBoard[i].length)
                    continue outer_loop;
                min = Math.min(min, countDiff(chessBoard, i, j));
            }
        }

        System.out.println(min);
    }

    public static int countDiff(char[][] chessBoard, int startRow, int startCol) {
        char[] color = {'W', 'B'};

        int cnt_1 = 0;
        int cnt_2 = 0;

        int pattern_1 = 0;
        int pattern_2 = 1;

        for(int i=startRow; i<startRow+8; i++) {
            for(int j=startCol; j<startCol+8; j++) {
                if(chessBoard[i][j] != color[pattern_1])
                    cnt_1++;
                else if(chessBoard[i][j] != color[pattern_2])
                    cnt_2++;
                pattern_1 ^= 1;
                pattern_2 ^= 1;
            }
            pattern_1 ^= 1;
            pattern_2 ^= 1;
        }

        return Math.min(cnt_1, cnt_2);
    }
}
```

