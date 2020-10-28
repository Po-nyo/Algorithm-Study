package subset.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nums = scan.nextLine().split(" ");
        int[] superSet = new int[nums.length];

        for(int i=0; i<nums.length; i++)
            superSet[i] = Integer.parseInt(nums[i]);

        new PowerSet().printEverySubset(superSet);
    }
}
