package ant_sequence.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        AntSequence antSequence = new AntSequence(scan.nextLine());

        while(scan.hasNextLine())
            System.out.println(antSequence.getNthSequence(Integer.parseInt(scan.nextLine())));
    }
}
