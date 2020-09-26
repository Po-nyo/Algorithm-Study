package number_rank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] nums = new int[m];

        for(int i=0; i<m; i++) {
            nums[i] = scan.nextInt();
        }

        new Solution().solve(n, nums);
    }
}
