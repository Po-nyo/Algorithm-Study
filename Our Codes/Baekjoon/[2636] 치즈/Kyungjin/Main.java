package boj_2636;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n_rows = scan.nextInt();
        int n_cols = scan.nextInt();

        int[][] cheese_arr = new int[n_rows][n_cols];

        for(int i=0; i<n_rows; i++) {
            for(int j=0; j<n_cols; j++)
                cheese_arr[i][j] = scan.nextInt();
        }

        Cheese cheese = new Cheese(cheese_arr);
        cheese.run();
    }
}
