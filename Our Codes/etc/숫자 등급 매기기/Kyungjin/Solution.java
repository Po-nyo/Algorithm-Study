package number_rank;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private String[] rankName = {"Normal", "Rare", "Super Rare", "Ultra Rare"};
    private Map<String, Integer> counts;

    public Solution() {
        this.counts = new HashMap<>();
        for(String rank: rankName)
            counts.put(rank, 0);
    }

    public void solve(int n, int[] nums) {
        for(int i=1; i<=n; i++) {
            String rank = this.rankName[getRank(i, nums)];
            counts.put(rank, counts.get(rank)+1);
        }

        for(int i=rankName.length-1; i>=0; i--)
            System.out.print(this.counts.get(rankName[i]) + " ");
    }

    private int getRank(int k, int[] nums) {
        if((k & k-1) == 0)
            return 3;
        else {
            int rank = 0;

            for (int num: nums) {
                if (k % num == 0)
                    rank++;

                if (rank >= 3)
                    return 3;
            }
            return rank;
        }
    }
}