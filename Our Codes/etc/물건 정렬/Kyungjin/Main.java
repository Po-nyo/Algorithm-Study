package sort_stuff.solution;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Stuff[] stuffs = new Stuff[n];

        for(int i=0; i<n; i++)
            stuffs[i] = new Stuff(scan.next(), scan.nextInt(), scan.next());

        Arrays.sort(stuffs);

        for(Stuff stuff : stuffs) {
            if(stuff.shelfLife.compareTo("2018/10/24") >= 0)
                System.out.println(stuff.name + " " + stuff.price + " " + stuff.shelfLife);
        }
    }

    static class Stuff implements Comparable<Stuff> {
        private String name;
        private int price;
        private String shelfLife;

        public Stuff(String name, int price, String shelfLife) {
            this.name = name;
            this.price = price;
            this.shelfLife = shelfLife;
        }

        @Override
        public int compareTo(Stuff other) {
            int compared = this.name.compareTo(other.name);
            if(compared != 0)
                return compared;

            compared = Integer.compare(this.price, other.price);
            if(compared != 0)
                return -compared;

            compared = this.shelfLife.compareTo(other.shelfLife);
            return compared;
        }
    }
}
