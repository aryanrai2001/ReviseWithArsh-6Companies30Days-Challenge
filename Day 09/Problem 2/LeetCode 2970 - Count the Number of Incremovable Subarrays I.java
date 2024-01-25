class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int total = 0;
        for (int i = 1; i <= nums.length; i++)
        {
            for (int j = 0; j <= nums.length-i; j++)
            {
                boolean inc = true;
                for (int k = 1; k < j && inc; k++)
                    inc = nums[k-1] < nums[k];
                if (inc && j > 0 && j < nums.length-i)
                    inc = nums[j-1] < nums[j+i];
                for (int k = j+i; k < nums.length-1 && inc; k++)
                    inc = nums[k] < nums[k+1];
                if (inc)
                    total++;
            }
        }
        return total;
    }
}