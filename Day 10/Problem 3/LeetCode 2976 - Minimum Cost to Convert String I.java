class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] adj = new long[26][26];
        for (int i = 0; i < 26; i++)
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        for (int i = 0; i < cost.length; i++)
        {
            long val = adj[original[i] - 'a'][changed[i] - 'a'];
            adj[original[i] - 'a'][changed[i] - 'a'] = Math.min(cost[i], val);
        }
        for (int k = 0; k < 26; k++)
        {
            for (int i = 0; i < 26; i++)
            {
                for (int j = 0; j < 26; j++)
                {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
        long total = 0;
        for (int i = 0; i < source.length(); i++)
        {
            int ch1 = source.charAt(i) - 'a';
            int ch2 = target.charAt(i) - 'a';
            if (ch1 == ch2)
                continue;
            long val = adj[ch1][ch2];
            if (val == Integer.MAX_VALUE)
                return -1;
            total += val;
        }
        return total;
    }
}