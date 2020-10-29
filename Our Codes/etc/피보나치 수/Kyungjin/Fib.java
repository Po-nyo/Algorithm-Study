package fibo.solution;

import java.util.ArrayList;
import java.util.List;

public class Fib {

    private List<Integer> fibList;

    public Fib(int n) {
        fibList = new ArrayList<>();

        fibList.add(0);
        fibList.add(1);

        for(int i=2; i<n; i++)
            fibList.add(fibList.get(i-2) + fibList.get(i-1));
    }

    public void solve(int k) {
        while(k > 0) {
            int max = 0;

            for(int i : fibList) {
                if(i > k)
                    break;
                max = i;
            }
            k -= max;
            System.out.print(max + " ");
        }
        System.out.println();
    }
}
