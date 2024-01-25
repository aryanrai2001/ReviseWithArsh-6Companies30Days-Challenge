class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int maxLen = -1, runningCost = 0, l = 0;
        for (int r = 0; r < n; r++)
        {
            runningCost += Math.abs(s.charAt(r) - t.charAt(r));
            while (runningCost > maxCost)
            {
                runningCost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}