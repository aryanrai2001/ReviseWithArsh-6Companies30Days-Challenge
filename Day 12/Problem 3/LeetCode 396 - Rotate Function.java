class Solution 
{
    public int maxRotateFunction(int[] nums) 
    {
        int n = nums.length;
        int arrSum = 0;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            arrSum += nums[i];
            sum += i * nums[i];
        }
        int max = sum;
        for (int i = 0; i < n; i++)
        {
            int lastVal = nums[n-1-i];
            sum = sum - (n * lastVal) + arrSum;
            if (sum > max)
                max = sum;
        }
        return max;
    }
}