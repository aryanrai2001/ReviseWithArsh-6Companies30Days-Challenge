class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int nice = 0;
        int[] numOdds = new int[nums.length + 1];
        int totalOdds = 0;
        HashMap<Integer, Integer> nices = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] % 2 != 0)
                totalOdds++;
            numOdds[i+1] = totalOdds;
        }
        int min = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (numOdds[i] >= k)
            {
                min = i;
                break;
            }
        }
        for (int i = 0; i < numOdds.length; i++)
            System.out.print(numOdds[i] + " ");
        for (int i = numOdds.length-1; i >= min; i--)
        {
            int target = numOdds[i] - k;
            int cache = nices.getOrDefault(target, -1);
            if (cache != -1)
            {
                nice += cache;
                continue; 
            }
            int currNice = 0;
            for (int j = 0; j < i; j++)
            {
                if (numOdds[j] == target)
                    currNice++;
            }
            nices.put(target, currNice);
            nice += currNice;
        }
        return nice;
    }
}