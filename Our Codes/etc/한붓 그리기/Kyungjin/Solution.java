package eulerian_trail.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void solve(int[][] graph) {
        List<Integer> oddList = new ArrayList<>();

        for(int i=0; i<graph.length; i++) {
            int degree  = 0;
            for(int j=0; j<graph[i].length; j++) {
                if(graph[i][j] == 1)
                    degree++;
            }
            if(degree % 2 != 0)
                oddList.add(i);
        }

        if(oddList.size() == 0)
            System.out.println("O");
        else if(oddList.size() == 2 || graph[oddList.get(0)][oddList.get(1)] == 1) {
            System.out.println("O");
        }
        else
            System.out.println("X");
    }
}