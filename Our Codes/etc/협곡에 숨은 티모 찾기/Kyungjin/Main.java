package find_teemo;

import java.util.Scanner;

public class Main {

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
}
