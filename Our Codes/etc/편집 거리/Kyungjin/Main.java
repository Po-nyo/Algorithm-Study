package edit_distance.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String a = scan.nextLine();
        String b = scan.nextLine();

        new Solution().solve(a, b);
    }
}
