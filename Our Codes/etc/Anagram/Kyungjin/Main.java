package anagram;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        new Anagram().solve(scan.nextLine(), scan.nextLine());
    }
}
