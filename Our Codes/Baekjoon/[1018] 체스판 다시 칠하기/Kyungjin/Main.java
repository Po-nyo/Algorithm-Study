package boj_1018;

import java.util.Scanner;

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
