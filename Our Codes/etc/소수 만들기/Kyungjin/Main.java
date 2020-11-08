package make_prime_number.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];

        for(int i=0; i<n; i++)
            nums[i] = scan.nextInt();

        Arrays.sort(nums);

        ArrayList<Integer> primeNumbers = new PrimeNumberMaker().getPrimeNumberList(nums);

        if(primeNumbers.isEmpty())
            System.out.println("No Prime!");
        else {
            for(int i : primeNumbers)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
