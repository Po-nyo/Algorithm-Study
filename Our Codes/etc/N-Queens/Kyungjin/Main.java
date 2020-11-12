package n_queens.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        new Solution().solve(scan.nextInt());
    }
}
