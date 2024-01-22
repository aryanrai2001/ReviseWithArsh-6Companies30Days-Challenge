class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int total = 0;
        int lastVal = 10000001;
        for(int i = nums.length-1; i > 0; i--)
        {
            int val = nums[i] - k;
            if (lastVal == val)
                continue;
            int h = i;
            int l = 0;
            while (l < h)
            {
                int m = l + (h-l)/2;
                if (nums[m] == val)
                {
                    total++;
                    break;
                }
                else if (nums[m] > val)
                    h = m;
                else
                    l = m + 1;
            }
            lastVal = val;
        }
        return total;
    }
}