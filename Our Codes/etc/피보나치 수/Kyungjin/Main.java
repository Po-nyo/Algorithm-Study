package fibo.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Fib fib = new Fib(100);

        for(int i=0; i<n; i++)
            fib.solve(scan.nextInt());
    }
}
