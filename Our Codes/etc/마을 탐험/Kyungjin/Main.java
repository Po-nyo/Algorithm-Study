package village_tour.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int l = scan.nextInt();

        int[][] graph = new int[l][l];

        scan.nextLine();
        for(int i=0; i<l; i++) {
            String line = scan.nextLine();
            parsing(graph, i, line);
        }

        int[] items = new int[scan.nextInt()];

        for(int i=0; i<items.length; i++)
            items[i] = scan.nextInt();

        System.out.println(new Solution().solve(graph, items));
    }

    public static void parsing(int[][] graph, int v0, String line) {
        String[] parse = line.split(" ");

        for(int i=0; i<graph.length; i++) {
            int weight = Integer.parseInt(parse[i+1]);

            graph[v0][i] = weight;
            graph[i][v0] = weight;
        }
    }
}
