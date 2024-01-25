class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], 10000);
        for (int i = 0; i < edges.length; i++)
        {
            int[] edge = edges[i];
            dp[edge[0]][edge[1]] = edge[2];
            dp[edge[1]][edge[0]] = edge[2];
            dp[edge[0]][edge[0]] = 0;
            dp[edge[1]][edge[1]] = 0;
        }
        
        for (int k = 0; k < n; k++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    dp[j][i] = dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int min = 10000;
        int vertex = -1;
        for (int i = 0; i < n; i++)
        {
            int count = 0;
            for (int j = 0; j < n; j++)
            {
                if (i == j || dp[j][i] == 10000)
                    continue;
                if (dp[i][j] <= distanceThreshold)
                {
                    count++;
                }
            }
            if (count <= min)
            {
                min = count;
                vertex = i;
            }
        }
        return vertex;
    }
}