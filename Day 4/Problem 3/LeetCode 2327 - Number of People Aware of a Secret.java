class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[forget];
        dp[0] = 1;
        for (int i = 1; i < n; i++)
        {
            int sum = 0;
            for (int j = forget-1; j > 0; j--)
            {
                int val = dp[j-1];
                if (j >= delay)
                    sum = (sum + val) % 1000000007;
                dp[j] = val;
            }
            dp[0] = sum;
        }
        int total = 0;
        for (int i = 0; i < forget; i++)
            total = (total + dp[i]) % 1000000007;
        return total;
    }
}