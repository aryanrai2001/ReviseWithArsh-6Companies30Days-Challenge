class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        int n = envelopes.size(); 
        if (n == 0)
            return 0;
        sort(envelopes.begin(), envelopes.end(), [](vector<int>& a, vector<int>& b) -> int
        {
            return (a[0] == b[0]) ? b[1] < a[1] : a[0] < b[0];
        });
        int dp[n];
        int max = 0;
        for(int i = 0; i < n; i++)
        {
            int l = 0;
            int h = max;
            int val = envelopes[i][1];
            int index = 0;
            while (l < h)
            {
                if (dp[index] == val)
                    break;
                else if (dp[index] > val)
                    h = index;
                else
                    l = index + 1;
                index = l + (h-l)/2;
            }
            dp[index] = val;
            if (index == max)
                max++;
        }
        return max;
    }
};