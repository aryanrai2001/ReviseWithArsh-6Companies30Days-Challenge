class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> set = new HashSet<String>();
        int[] divs = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++)
            divs[i+1] = divs[i] + ((nums[i] % p == 0) ? 1 : 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i; j < nums.length; j++)
            {
                sb.append(nums[j]);
                sb.append(' ');
                if (divs[j+1] - divs[i] <= k)
                    set.add(sb.toString());
            }
            sb.setLength(0);
        }
        return set.size();
    }
}