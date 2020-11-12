package automata.solution;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Automata automata = new Automata();

        while(scan.hasNextLine()) {
            int[] sequence = Arrays.stream(scan.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            automata.solve(sequence);
        }
    }
}
