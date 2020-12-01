package diamond_area.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[][] map = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                map[i][j] = scan.nextInt();
        }

        new Solution().solve(map);
    }
}
