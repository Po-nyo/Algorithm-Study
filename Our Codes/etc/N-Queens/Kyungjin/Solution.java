package n_queens.solution;

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
