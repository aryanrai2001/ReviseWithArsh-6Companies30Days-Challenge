class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1)
            return;
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int index = 1;
        for (int i = nums.length-1; i >= 0; i--)
        {
            res[index] = nums[i];
            index+=2;
            if (index >= nums.length)
                index = 0;
        }
        for (int i = 0; i < nums.length; i++)
            nums[i] = res[i];
    }
}