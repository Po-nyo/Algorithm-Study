package climbing.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Solution solution = new Solution();

        while(scan.hasNextLine()) {
            int row = scan.nextInt();
            int col = scan.nextInt();
            int max_height = scan.nextInt();
            int time_limit = scan.nextInt();
            scan.nextLine();

            int[][] map = new int[row][col];
            for(int i=0; i<row; i++) {
                String line = scan.nextLine();

                for(int j=0; j<line.length(); j++)
                    map[i][j] = line.charAt(j) - 'A';
            }

            int highest_loc = solution.solve(map, max_height, time_limit);
            System.out.println(highest_loc);
        }
    }
}
