package dijkstra.solution;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();

        for(int i=0; i<testCase; i++) {
            int nodes = scan.nextInt();
            int edges = scan.nextInt();

            int[][] graph = new int[nodes][nodes];

            for(int j=0; j<edges; j++)
                insertEdge(graph, scan.nextInt()-1, scan.nextInt()-1, scan.nextInt());

            Solution solution = new Solution();
            int shortest = solution.solve(graph, scan.nextInt()-1, scan.nextInt()-1, scan.nextInt()-1);
            System.out.println(shortest);
        }
    }

    public static void insertEdge(int[][] graph, int v0, int v1, int weight) {
        graph[v0][v1] = weight;
        graph[v1][v0] = weight;
    }
}
