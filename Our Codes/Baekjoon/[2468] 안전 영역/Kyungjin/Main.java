package boj_2468;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] heights = new int[n][n];
        int max_height = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                heights[i][j] = scan.nextInt();
                max_height = Math.max(max_height, heights[i][j]);
            }
        }

        new Solution().solve(heights, max_height);
    }
}
