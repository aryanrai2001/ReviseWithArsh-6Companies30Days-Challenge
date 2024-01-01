class Solution {
public:
    int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) 
    {
        int l = 2;
        int h = INT_MAX;
        int totalVals = uniqueCnt1 + uniqueCnt2;
        int lcmVal = lcm(divisor1, divisor2);
        int ans = h;
        while (l <= h)
        {
            int m = l + (h-l)/2;
            int d1 = m - m/divisor1;
            int d2 = m - m/divisor2;
            int d = m - m/lcmVal;
            if (d1 >= uniqueCnt1 && d2 >= uniqueCnt2 && d >= totalVals)
            {
                ans = min(ans, m);
                h = m-1;
            }
            else
                l = m+1;
        }
        return ans;
    }
};