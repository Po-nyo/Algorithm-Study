# N-Queens

## 풀이

백트래킹을 연습해볼 수 있는 대표적인 문제이다.

나는 처음 문제를 보고 2차원 배열의 체스판을 만들고 백트래킹을 하려고 하다가,

문득 어차피 체스판은 정사각행렬이고 퀸은 한 행에 하나만 있을 수 있는 것은 명백하기 때문에

1차원 배열로도 충분히 할 수 있겠다고 생각해서 1차원 배열로 풀어보았다.

사실 2차원 배열을 사용하는 것이 생각하기는 더 편하지만 그냥 이렇게도 할 수 있겠구나 싶어서 진행했다.

1차원 배열을 통해서 배열의 인덱스를 행으로 생각하고, 원소를 열 번호로 생각하면 1차원 배열로도 퀸의 위치를 특정시킬 수 있다.

나는 0행 부터 시작해서 행마다 퀸이 놓일 수 있는 위치를 정하고,

다음 행으로 진행하면서 행마다 퀸의 위치를 특정 후 모든 행에 대해 가능한 퀸의 위치가 정해지면 출력하는 방식으로 진행했다.

```java
public class Solution {

    public void solve(int n) {
        int[] chessBoard = new int[n];
        backtrack(chessBoard, 0, n);
    }

    private void backtrack(int[] chessBoard, int row, int n) {
        if(row == n)
            printSolution(chessBoard);
        else {
            for(int i=0; i<chessBoard.length; i++) {
                if(isPromising(chessBoard, row, i)) {
                    chessBoard[row] = i;
                    backtrack(chessBoard, row + 1, n);
                }
            }
        }
    }

    private boolean isPromising(int[] row_board, int row, int col) {
        for(int i=0; i<row; i++) {
            if(
                    row_board[i] == col ||
                    row_board[i]+(row-i) == col ||
                    row_board[i]-(row-i) == col)
                return false;
        }

        return true;
    }

    private void printSolution(int[] chessBoard) {
        for(int col : chessBoard) {
            for(int i=0; i<chessBoard.length; i++) {
                if(col == i)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
```
