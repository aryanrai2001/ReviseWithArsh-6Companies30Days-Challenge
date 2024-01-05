class Solution {
    private int[][] dp;
    public int numberOfWays(int startPos, int endPos, int k) {
        int diff = Math.abs(endPos-startPos);
        dp = new int[1000][k+1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        return count(diff, k);
    }
    private int count(int diff, int k)
    {
        if (k == 0) {
            if (diff == 0)
                return 1;
            else
                return 0;
        }
        if (k < diff)
            return 0;
        if (k == diff)
            return 1;
        if (dp[diff][k] != -1)
            return dp[diff][k];
        
        int total = 0;
        total = (total + count(Math.abs(diff + 1), k-1)) % 1000000007;
        total = (total + count(Math.abs(diff - 1), k-1)) % 1000000007;
        dp[diff][k] = total;
        return total;
    }
}