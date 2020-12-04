package edit_distance.solution;

public class Solution {

    public void solve(String a, String b) {
        a = " " + a;
        b = " " + b;

        int[][] dp = new int[a.length()][b.length()];
        for(int i=0; i<dp.length; i++)
            dp[i][0] = i * 3;

        for(int i=0; i<dp[0].length; i++)
            dp[0][i] = i * 2;


        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[i].length; j++) {
                if(a.charAt(i) == b.charAt(j))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j - 1] + 2);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 3);
                }
            }
        }

        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
}
