package eulerian_trail.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] graph = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                graph[i][j] = scan.nextInt();
        }

        new Solution().solve(graph);
    }
}
